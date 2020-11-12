/* OOP 3200 - Java Lab 1
 * Ryan Clayson and Daniel Hinbest
 * 100558837		100717231
 * November 12, 2020
 */
package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //define scanner
        Scanner keyboard = new Scanner(System.in);

        //Array of bowlers
        String bowlers[] = {"Ryan", "Daniel", "Tom"};
        //Games array
        int[][] scores = new int [3][2];

        //Variables
        float average = 0.0f;
        boolean isValid = false;

        //Input
        //Outer loop for bowlers
        for (int i = 0; i < 3; i++)
        {
            //Inner loop for games
            for (int j = 0; j < 2; j++)
            {
                do {
                    try
                    {
                        //Display message to prompt user to enter score
                        System.out.printf("Please enter " + bowlers[i] + " for GAME #" + (j + 1) + ": ");
                        scores[i][j] = keyboard.nextInt();
                        isValid = true;

                        //Checks to see if user has entered a valid score
                        if((scores[i][j] < 0) || (scores[i][j] > 300))
                        {
                            System.out.println("Invalid Input. Value must be between 0 and 300. Try again.");
                            keyboard.nextLine();
                            isValid = false;
                        }
                    }
                    // Numeric input was not received
                    catch (InputMismatchException ex)
                    {
                        System.out.println("Error: You must enter a valid integer point number");
                        keyboard.nextLine();
                        isValid = false;
                    }
                } while (!isValid);
            }
            System.out.println();
        }

        //Output loop to display bowlers/scores
        for (int i = 0; i < 3; i++)
        {
            average = 0.0f;
            System.out.println("\nScore Details for " + bowlers[i] + ":");

            //Inner loop for games
            for (int j = 0; j < 2; j++)
            {
                System.out.println("Game #" + (j + 1) + ": " + scores[i][j]);
                average += scores[i][j];
            }

            //Calculation for Average
            average = average / 2;
            System.out.println("Average for " + bowlers[i] + ": " + average);
        }
    }
}
