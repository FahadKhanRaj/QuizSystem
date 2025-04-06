package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class Student {
    Scanner scanner = new Scanner(System.in);

    public void takeQuiz() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray quizArray = (JSONArray) parser.parse(new FileReader("quiz.json"));

            List<JSONObject> questions = new ArrayList<>();
            for (Object obj : quizArray) {
                questions.add((JSONObject) obj);
            }

            Collections.shuffle(questions);
            int score = 0;

            for (int i = 0; i < 10 && i < questions.size(); i++) {
                JSONObject q = questions.get(i);
                System.out.println("[Question " + (i + 1) + "] " + q.get("question"));
                System.out.println("1. " + q.get("option 1"));
                System.out.println("2. " + q.get("option 2"));
                System.out.println("3. " + q.get("option 3"));
                System.out.println("4. " + q.get("option 4"));
                System.out.print("Student:> ");

                int ans = -1;
                try {
                    ans = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {}

                long correct = (long) q.get("answerkey");
                if (ans == correct) {
                    score++;
                }
            }

            System.out.println();
            if (score >= 8) {
                System.out.println("Excellent! You have got " + score + " out of 10");
            } else if (score >= 5) {
                System.out.println("Good. You have got " + score + " out of 10");
            } else if (score >= 2) {
                System.out.println("Very poor! You have got " + score + " out of 10");
            } else {
                System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
            }

            System.out.println("Would you like to start again? press s for start or q for quit");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                takeQuiz();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
