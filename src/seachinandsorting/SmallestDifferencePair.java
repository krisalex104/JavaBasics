package seachinandsorting;

import java.util.Scanner;

public class SmallestDifferencePair {
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int smallestDifferencePair(int []arr1, int n, int []arr2, int m) {
        // Write your code here.
        int temp=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int difference;
                if(arr1[i]>arr2[j]){
                    difference=arr1[i] - arr2[j];
                }else{
                    difference=arr2[j]-arr1[i];
                }
                if(difference<=temp){
                    temp=difference;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        int n= arr1.length;;
        int m=arr2.length;
        int smallestDifference = smallestDifferencePair(arr1, n, arr2, m);
        System.out.println(smallestDifference);

    }
}
