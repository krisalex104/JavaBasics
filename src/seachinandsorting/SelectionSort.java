package seachinandsorting;

import java.util.Scanner;

public class SelectionSort {
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void selectionSort(int[] arr){
        for(int i=0;i< arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = takeInput();
        selectionSort(arr);
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
}
