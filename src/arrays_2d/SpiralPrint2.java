package arrays_2d;

public class SpiralPrint2 {

    /*This solution uses four variables (rowBegin, rowEnd, colBegin, colEnd) to keep track of the starting and
     ending indices for rows and columns. The solution starts by printing the first row, then the last column,
     then the last row, and finally the first column. The rowBegin and colBegin variables are incremented,
     and rowEnd and colEnd are decremented after each iteration, until all elements in the matrixay have been printed.*/
    public static void printSpiral(int[][] matrix) {
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Print the first row from the remaining rows
            for (int j = colBegin; j <= colEnd; j++) {
                System.out.print(matrix[rowBegin][j] + " ");
            }
            rowBegin++;

            // Print the last column from the remaining columns
            for (int i = rowBegin; i <= rowEnd; i++) {
                System.out.print(matrix[i][colEnd] + " ");
            }
            colEnd--;

            // Print the last row from the remaining rows
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    System.out.print(matrix[rowEnd][j] + " ");
                }
                rowEnd--;
            }

            // Print the first column from the remaining columns
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    System.out.print(matrix[i][colBegin] + " ");
                }
                colBegin++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printSpiral(matrix);
    }
}

