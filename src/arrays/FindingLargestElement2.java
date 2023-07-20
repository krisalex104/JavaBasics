package arrays;

import java.util.Scanner;

public class FindingLargestElement2 {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static int printLargest(int[] arr){
        int size= arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int largest = printLargest(input);
        System.out.println(largest);
    }
}
