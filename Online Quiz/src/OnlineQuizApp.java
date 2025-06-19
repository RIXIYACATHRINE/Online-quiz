import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswerIndex + 1;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"}, 1));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"super", "this", "extends", "final"}, 2));
        questions.add(new Question("Who invented Java?",
                new String[]{"Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Steve Jobs"}, 1));
        questions.add(new Question("What is the default value of int in Java?",
                new String[]{"0", "null", "undefined", "1"}, 0));
        questions.add(new Question("Which method is the entry point in Java?",
                new String[]{"start()", "init()", "main()", "run()"}, 2));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("💡 Welcome to the Java Quiz!");
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();
            if (q.checkAnswer(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
            }
        }

        System.out.println("🎉 Quiz Finished!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}

