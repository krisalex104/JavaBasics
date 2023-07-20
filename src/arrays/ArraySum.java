package arrays;

import java.util.Scanner;

public class ArraySum {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static void printSum(int[] arr){
        int size= arr.length;
        int sum=0;
        for(int i=0;i<size;i++){
            sum=sum+arr[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        printSum(input);
    }
}
