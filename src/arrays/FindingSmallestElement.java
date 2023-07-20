package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FindingSmallestElement {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static void printSmallestElement(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println(arr[0]);

    }
    public static void main(String[] args) {
        int[] input = takeInput();
        printSmallestElement(input);
    }
}
