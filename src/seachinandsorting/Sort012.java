package seachinandsorting;

import java.util.Scanner;

public class Sort012 {
    //code for sorting in one scan
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void sort012(int[] arr){
        int indexOf0 = 0;
        int IndexOf2 = arr.length -1;
        int i = 1;
        int temp = 0;
        while(i < arr.length )  {
            if(arr[i] == 0 && i > indexOf0) {
                temp = arr[i];
                arr[i] = arr[indexOf0];
                arr[indexOf0] = temp;
                indexOf0++;
            } else if(arr[i] == 2 && i < IndexOf2) {
                temp = arr[i];
                arr[i] = arr[IndexOf2];
                arr[IndexOf2] = temp;
                IndexOf2--;
            } else
                i++;
        }
    }
    public static void main(String[] args) {
        int[] input = takeInput();
        sort012(input);
        for(int i=0;i< input.length;i++){
            System.out.print(input[i] + " ");
        }
    }
}
