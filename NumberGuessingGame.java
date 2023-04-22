import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "yes";
        int roundsPlayed = 0, totalScore = 0, totalAttempts = 0;

        System.out.println("Welcome to the number guessing game!");
        System.out.println("A number between 1 and 100 will be chosen. You have 5 attempts to guess it.\n");

        while (playAgain.equalsIgnoreCase("yes")) {
            roundsPlayed++;

            int guess, attemptsLeft = 5, attemptsTaken = 0, score = 5;
            Random random = new Random();
            int targetNumber = random.nextInt(100) + 1;

            for (int i = 1; i <= attemptsLeft; i++) {
                System.out.print("Attempt " + i + ": Enter your guess (1-100): ");
                guess = scanner.nextInt();
                attemptsTaken++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("Attempts taken: " + attemptsTaken + ", Score: " + score + "\n");
                    totalAttempts += attemptsTaken;
                    totalScore += score;
                    System.out.print("Do you want to play again? (yes or no): ");
                    playAgain = scanner.next().toLowerCase();
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("The number is higher.");
                    score--;
                } else {
                    System.out.println("The number is lower.");
                    score--;
                }
            }

            if (attemptsTaken == attemptsLeft) {
                System.out.println("Sorry, you couldn't guess the number within 5 attempts.");
                System.out.println("The number was " + targetNumber + ".");
                totalAttempts += attemptsTaken;
                totalScore += score;
                System.out.println("Attempts taken: " + attemptsTaken + ", Score: " + score + "\n");
                System.out.print("Do you want to play again? (yes or no): ");
                playAgain = scanner.next().toLowerCase();
            }
        }

        System.out.println("Thanks for playing the number guessing game!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total attempts taken: " + totalAttempts);
        System.out.println("Total score: " + totalScore);
    }
}
