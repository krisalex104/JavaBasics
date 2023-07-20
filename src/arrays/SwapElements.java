package arrays;

import java.util.Scanner;

public class SwapElements {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }


    public static int[] swapElements(int[] input){
        int temp=0;
        for (int i=0;i< input.length-1;i+=2){
                 temp=input[i];
                input[i]=input[i+1];
                input[i+1]=temp;

        }
        return input;
    }

    public static void printElements(int[] input){
        for(int i=0;i< input.length;i++){
            System.out.print(input[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] input = takeInput();
        int[] swapElements = swapElements(input);
        printElements(swapElements);

    }
}
