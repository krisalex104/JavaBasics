package datastructure.dynamicprogramming;

import java.util.Arrays;


/**
 * Miss. Noor Rashid is a teacher. She wants to give some chocolates to the students in her class.
 * All the students sit in a line, and each of them has a score according to performance.
 * Noor wants to give at least one chocolate to each student.
 * She distributes chocolates to them such that If two students sit next to each other,
 * then the one with the higher score must get more chocolates. Miss. Noor wants to save money,
 * so she wants to minimize the total number of chocolates.
 * Note :
 * When two students have an equal score, they are allowed to have a different number of chocolates.
 */
public class MinNoOfChocolates {
    public static int getMin(int arr[], int N){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[] chocolates = new int[N];

        // Initialize each student with one chocolate
        Arrays.fill(chocolates, 1);

        // Traverse the scores from left to right
        for (int i = 1; i < N; i++) {
            // Check if the current student has a higher score than the previous student
            if (arr[i] > arr[i - 1]) {
                // Give one more chocolate to the current student than the previous student
                chocolates[i] = chocolates[i - 1] + 1;
            }
        }

        // Traverse the scores from right to left
        for (int i = N - 2; i >= 0; i--) {
            // Check if the current student has a higher score than the next student
            if (arr[i] > arr[i + 1]) {
                // Take the maximum of the current chocolate count and (next student's chocolate count + 1)
                chocolates[i] = Math.max(chocolates[i], chocolates[i + 1] + 1);
            }
        }

        // Calculate the total number of chocolates
        int totalChocolates = 0;
        for (int i = 0; i < N; i++) {
            totalChocolates += chocolates[i];
        }

        return totalChocolates;
    }
    public static void main(String[] args) {

    }
}
