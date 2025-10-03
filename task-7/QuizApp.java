import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which language is platform-independent?", new String[]{"1. C", "2. Java", "3. Python", "4. C++"}, 2));
        questions.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"1. this", "2. super", "3. extends", "4. implements"}, 3));
        questions.add(new Question("Which collection does not allow duplicates?", new String[]{"1. List", "2. Set", "3. Map", "4. Queue"}, 2));
        questions.add(new Question("Which is not an OOP concept?", new String[]{"1. Encapsulation", "2. Inheritance", "3. Polymorphism", "4. Compilation"}, 4));
        questions.add(new Question("What is JVM?", new String[]{"1. Java Virtual Machine", "2. Java Variable Method", "3. Java Verified Mode", "4. Java Version Manager"}, 1));

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();
            if (q.checkAnswer(answer)) {
                score++;
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        sc.close();
    }
}
