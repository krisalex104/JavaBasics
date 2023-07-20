package arrays;

import java.util.Scanner;

public class ArrangeNumbers {
    public static void arrange(int[] arr, int n) {
        //Your code goes here
        int a=1;
        int b=0;
        int c;
        for (int i = 0; i < n; i++) {
            int x;
            if(n%2==0){
                x=n/2;
                c=0;
            }else{
                x=n/2+1;
                c=1;
            }
                if (i < x) {
                    arr[i] = i + a;
                    a++;
                } else {
                    arr[i] = n - c - b;
                    b = b + 2;
                }
                System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[]=new int[6];
        arrange(arr,6);
    }
}
