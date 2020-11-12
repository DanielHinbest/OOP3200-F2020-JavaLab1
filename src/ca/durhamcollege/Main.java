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
        int[][] scores = new int [3][2];

        float average = 0.0f;
        boolean isValid = false;

        //Input
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                do {
                    try
                    {
                        System.out.printf("Please enter " + bowlers[i] + " for GAME #" + (j + 1) + ": ");
                        scores[i][j] = keyboard.nextInt();
                        isValid = true;

                        if((scores[i][j] < 0) || (scores[i][j] > 300))
                        {
                            System.out.println("Invalid Input. Value must be between 0 and 300. Try again.");
                            keyboard.nextLine();
                            isValid = false;
                        }
                    } catch (InputMismatchException ex)
                    {
                        System.out.println("Error: You must enter a valid integer point number");
                        keyboard.nextLine();
                        isValid = false;
                    }
                } while (!isValid);
            }
            System.out.println();
        }

        //Output
        for (int i = 0; i < 3; i++)
        {
            average = 0.0f;
            System.out.println("\nScore Details for " + bowlers[i] + ":");
            for (int j = 0; j < 2; j++)
            {
                System.out.println("Game #" + (j + 1) + ": " + scores[i][j]);
                average += scores[i][j];
            }

            average = average / 2;
            System.out.println("Average for " + bowlers[i] + ": " + average);
        }
    }
}
