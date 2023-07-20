package seachinandsorting;

import java.util.Scanner;

public class BubbleSort {
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void bubbleSort(int[] arr){

        for(int i=0;i< arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                int temp=arr[j];
                if(temp>arr[j+1]){
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        bubbleSort(input);
        for(int i=0;i< input.length;i++){
            System.out.print(input[i] + " ");
        }
    }
}
