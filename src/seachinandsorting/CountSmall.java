package seachinandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountSmall {
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static int[] countS(int n, int m, int []a, int []b) {
        // Write your code here.
        int[] arr=new int[a.length];

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if(a[i]>=b[j]){
                    count++;
                }
            }
            arr[i]=count;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        int[] counts = countS(arr1.length, arr2.length, arr1, arr2);
        System.out.println(Arrays.toString(counts));
    }
}
