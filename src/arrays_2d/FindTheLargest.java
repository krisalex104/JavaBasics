package arrays_2d;

import java.util.Scanner;

public class FindTheLargest {
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
    public static void largestColumnSum(int[][] mat) {

        int rows = mat.length;

        int largestSum=Integer.MIN_VALUE;
        int index=0;
        boolean row=true;
        if(rows==0){
            System.out.print("row "+index+" "+largestSum+" ");
            return;
        }

        for (int i = 0; i < rows; i++) {
            int columns = mat[0].length;
            int rowSum = 0;
            for (int j = 0; j < columns; j++) {
                rowSum += mat[i][j];

            }
            if (rowSum > largestSum) {
                largestSum = rowSum;
                index = i;
            }
        }
             int columns = mat[0].length;
            for (int j = 0; j < columns; j++) {
                int colSum = 0;
                for (int i = 0; i < rows; i++) {
                    colSum += mat[i][j];
                }
                if (colSum > largestSum) {
                    largestSum = colSum;
                    index = j;
                    row=false;
                }
            }
            if (row) {
                System.out.println("column " + index + " " + largestSum + " ");
            }
            System.out.println("row " + index + " " + largestSum + " ");

    }
    public static void main(String[] args) {
        int[][] input = takeInput();
         largestColumnSum(input);
    }
}
