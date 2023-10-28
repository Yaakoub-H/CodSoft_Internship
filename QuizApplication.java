
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static Timer timer = new Timer();
    private static int score = 0;
    private static int questionIndex = 0;

    private static final String[] questions = {
    	    "Which keyword is used to declare a constant in Java?",
    	    "What is the main purpose of the 'static' keyword in Java?",
    	    "Which Java data type is used to represent a single 16-bit Unicode character?",
    	    "What is the process of converting an object into a byte stream called in Java?",
    	    "Which access modifier allows a variable to be accessed from any class in the same package?",
    	    "What is the purpose of the 'this' keyword in Java?",
    	};

    private static final String[][] options = {
    	    {"A) const", "B) static", "C) final", "D) var"},
    	    {"A) To create an instance of a class", "B) To declare a constant", "C) To indicate a class is final", "D) To allow access to non-static members from a static context"},
    	    {"A) int", "B) char", "C) byte", "D) String"},
    	    {"A) Serialization", "B) Transformation", "C) Casting", "D) Encoding"},
    	    {"A) public", "B) private", "C) protected", "D) default"},
    	    {"A) To declare a variable", "B) To call another constructor of the same class", "C) To define a new class", "D) To access the superclass constructor"},
    	};
    private static final int[] answers =  {2, 4, 2, 1, 4, 2}; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        startQuiz(scanner);
    }

    private static void startQuiz(Scanner scanner) {
        if (questionIndex < questions.length) {
            System.out.println("\nQuestion " + (questionIndex + 1) + ": " + questions[questionIndex]);
            for (String option : options[questionIndex]) {
                System.out.println(option);
            }

            int correctAnswer = answers[questionIndex];
            int selectedAnswer = -1;

            System.out.print("Enter the number of your answer (1, 2, 3, or 4): ");
            try {
                selectedAnswer = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                scanner.nextLine();
            }

            if (selectedAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + options[questionIndex][correctAnswer - 1]);
            }

            questionIndex++;
            setTimer(scanner);
        } else {
            showResults();
        }
    }

    private static void setTimer(Scanner scanner) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                startQuiz(scanner);
            }
        }, 2000); 
    }

    private static void showResults() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
    }
}

