import java.util.Random;
import java.util.Scanner;

public class Ass_01_Craps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int point = 0;
            int roll = rollDice(random);
            System.out.println("You rolled: " + roll);

            // Determine initial outcome
            if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("Craps! You crapped out.");
                playAgain = askToPlayAgain(scanner);
            } else if (roll == 7 || roll == 11) {
                System.out.println("Natural! You win!");
                playAgain = askToPlayAgain(scanner);
            } else {
                point = roll; // Set the point
                System.out.println("The point is now: " + point);
                playAgain = true; // Continue rolling

                while (playAgain) {
                    roll = rollDice(random);
                    System.out.println("You rolled: " + roll);

                    if (roll == point) {
                        System.out.println("Made the point! You win!");
                        playAgain = askToPlayAgain(scanner);
                    } else if (roll == 7) {
                        System.out.println("Got a seven! You lose.");
                        playAgain = askToPlayAgain(scanner);
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Method to roll two dice and return the sum
    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1; // Die 1 roll (1-6)
        int die2 = random.nextInt(6) + 1; // Die 2 roll (1-6)
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2);
        return die1 + die2; // Return the sum of the two dice
    }

    // Method to ask the user if they want to play again
    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }
}
