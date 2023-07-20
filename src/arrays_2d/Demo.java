package arrays_2d;

import java.util.Scanner;

public class Demo {
    public static void takeInputAndPrint(){
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


        int sum=0;
        if(rows==0 || columns==0){
            System.out.println(sum);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                sum+=input[i][j];
                System.out.print(input[i][j] + " ");

            }
            System.out.println(sum);
            sum=0;
        }
    }

    public static void main(String[] args) {
        takeInputAndPrint();
        int[][] ints={{2,3,4},{5,6,7}};
        System.out.println(ints[1][2]);

        int arr[][]=new int[4][5];
        for(int i=0;i<5;i++)
        {
            arr[i][0]=2;
        }
        System.out.print(arr[3][0]);
    }
}
