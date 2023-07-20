package arrays_2d;

import java.util.Scanner;

public class DiagonalBoundarySum {

    public static int[][] takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("number of rows");
        int rows=sc.nextInt();
        System.out.println("number of columns");
        int columns=sc.nextInt();
        int[][] input =new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.println("Enter element at "+i+" row "+j+" column");
                input[i][j]=sc.nextInt();
            }
        }
        return input;
    }

    public static void totalSum(int[][] mat) {
        //Your code goes here
        int requiredSum = 0;

        // Traverse arr[][]
        // Loop from i to N-1 for rows
        int rows = mat.length;
        int cols=mat[0].length;
        for (int i = 0; i < rows; i++) {

            // Loop from j = N-1 for columns
            for (int j = 0; j < cols; j++) {

                // Condition for diagonal
                // elements
                if (i == j || (i + j) == rows - 1) {
                    requiredSum += mat[i][j];
                }

                // Condition for Boundary
                // elements
                else if (i == 0 || j == 0 || i == rows - 1|| j == rows - 1) {
                    requiredSum += mat[i][j];
                }
            }
        }

        // Print the final Sum
        System.out.println(requiredSum);
    }

    public static void main(String[] args) {

    }
}
