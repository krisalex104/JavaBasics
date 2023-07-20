package arrays_2d;

import java.util.Scanner;

public class RowWiseSum {
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
    public static void rowWiseSum(int[][] mat) {

        int rows = mat.length;
        int sum = 0;
        if(rows==0){
            System.out.print("");
        }else{
            int columns = mat[0].length;
            // Your code goes here
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum += mat[i][j];

                }
                System.out.print(sum + " ");
                sum = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] input = takeInput();
        rowWiseSum(input);
    }
}
