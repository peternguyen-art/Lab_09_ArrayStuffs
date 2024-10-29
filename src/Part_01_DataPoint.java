import java.util.Random;
import java.util.Scanner;

public class Part_01_DataPoint {
    public static double getAverage(int values[]) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return (double) sum / values.length;
    }

    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int sum = 0;
        double avg = 0;
        int countGuess = 0;
        boolean found = false;
        int position = -1;

        int guess = SafeInput.getInt(in, "Your first guess");
        int guess2 = SafeInput.getInt(in, "Your second guess is");

        for (int count = 0; count < dataPoints.length; count++) {
            dataPoints[count] = rand.nextInt(100) + 1;
            if (guess == dataPoints[count]) {
                countGuess++;
            }
        }

        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.printf("\n");

        for (int j = 0; j < dataPoints.length; j++) {
            sum += dataPoints[j];
        }
        avg = sum / dataPoints.length;
        System.out.println("Sum of the array dataPoints is " + sum);
        System.out.println("Average of the array dataPoints is " + avg);

        if (countGuess != 0) {
            System.out.println("Your guess of " + guess + " was found " + countGuess + " times in the array");
        } else {
            System.out.println("Your guess was not found in the array");
        }


        for (int i = 0; i < dataPoints.length; i++) {
            if (guess2 == dataPoints[i]) {
                position = i;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The value " + guess2 + " was found at array index " + position + " ");
        } else {
            System.out.println("The value " + guess2 + " was not found in the array.");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 0; i < dataPoints.length; i++) {
            if (min > dataPoints[i]) {
                min = dataPoints[i];
            }
            if (max < dataPoints[i]) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value of the array is " + min);
        System.out.println("The maximum value of the array is " + max);
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }
}

