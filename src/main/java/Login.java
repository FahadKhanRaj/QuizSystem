package Quiz;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Login {
    Scanner scanner = new Scanner(System.in);

    public void loginUser() {
        System.out.println("System:> Enter your username");
        String username = scanner.nextLine();
        System.out.println("System:> Enter password");
        String password = scanner.nextLine();

        String role = validateUser(username, password);
        if (role != null) {
            if (role.equals("admin")) {
                System.out.println("System:> Welcome admin! Please create new questions in the question bank.");
                Admin admin = new Admin();
                admin.addQuestions();
            } else {
                System.out.println("System:> Welcome " + username + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
                String start = scanner.nextLine();
                if (start.equals("s")) {
                    Student student = new Student();
                    student.takeQuiz();
                }
            }
        } else {
            System.out.println("System:> Invalid username or password.");
        }
    }

    private String validateUser(String username, String password) {
        try (Reader reader = new FileReader("users.json")) {
            JSONParser parser = new JSONParser();
            JSONArray usersArray = (JSONArray) parser.parse(reader);
            for (Object obj : usersArray) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").equals(username) && user.get("password").equals(password)) {
                    return (String) user.get("role");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading users.json");
        }
        return null;
    }
}
