package arrays;

import java.util.Scanner;

public class FindingSmallestElement1 {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static int printSmallest(int[] arr){
        int size= arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int largest = printSmallest(input);
        System.out.println(largest);
    }
}
