package arrays_2d;

import java.util.Scanner;

public class WavePrint {

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
    public static void wavePrint(int mat[][]){
        //Your code goes here
        if(mat.length==0){
            return;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= mat.length-1; j++) {
                    System.out.print(mat[j][i]+" ");
                }
            }
            else if (i % 2 != 0) {
                for (int j = mat.length - 1; j >= 0; j--) {
                    System.out.print(mat[j][i]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
