package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);

    public void addQuestions() {
        JSONArray quizArray = new JSONArray();
        try {
            File file = new File("quiz.json");
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                quizArray = (JSONArray) parser.parse(new FileReader(file));
            }

            while (true) {
                System.out.println("System:> Input your question");
                String question = scanner.nextLine();

                System.out.println("System: Input option 1:");
                String opt1 = scanner.nextLine();

                System.out.println("System: Input option 2:");
                String opt2 = scanner.nextLine();

                System.out.println("System: Input option 3:");
                String opt3 = scanner.nextLine();

                System.out.println("System: Input option 4:");
                String opt4 = scanner.nextLine();

                System.out.println("System: What is the answer key?");
                int answer = Integer.parseInt(scanner.nextLine());

                JSONObject obj = new JSONObject();
                obj.put("question", question);
                obj.put("option 1", opt1);
                obj.put("option 2", opt2);
                obj.put("option 3", opt3);
                obj.put("option 4", opt4);
                obj.put("answerkey", answer);

                quizArray.add(obj);
                System.out.println("System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("q")) break;
            }

            FileWriter writer = new FileWriter("quiz.json");
            writer.write(quizArray.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
