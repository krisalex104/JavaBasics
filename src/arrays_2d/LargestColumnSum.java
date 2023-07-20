package arrays_2d;

import java.util.Scanner;

public class LargestColumnSum {
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
    public static int largestColumnSum(int[][] mat) {

        int rows = mat.length;

        int largest=Integer.MIN_VALUE;
        if(rows==0){
            System.out.print("");
        }else{
            int columns = mat[0].length;
            for (int i = 0; i < columns; i++) {
                int sum = 0;
                for (int j = 0; j < rows; j++) {
                    sum = sum + mat[j][i];
                }
                if(sum>largest){
                    largest=sum;
                }
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int[][] input = takeInput();
        int largestColumnSum = largestColumnSum(input);
        System.out.println(largestColumnSum);
    }
}
