import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 100;
        int attempts = 0;
        int rounds = 0;
        int totalAttempts = 0;

        while (true) {
            int secretNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            System.out.println("answer " + secretNumber);
            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess the number between " + minNum + " and " + maxNum);

            while (true) {
                try {
                    System.out.print("\nEnter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else if (userGuess > secretNumber) {
                        System.out.println("Too high. Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        rounds++;
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        if (rounds > 0) {
            double averageAttempts = (double) totalAttempts / rounds;
            System.out.println("You played " + rounds + " rounds with an average of " + String.format("%.2f", averageAttempts) + " attempts per round.");
            System.out.println("Thank You! \nEnd Game.");
        }

        scanner.close();
    }

}
