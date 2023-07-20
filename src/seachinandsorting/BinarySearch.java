package seachinandsorting;

import java.util.Scanner;

public class BinarySearch {

    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        return input;
    }

    public static int binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start <= end) {
             mid = (start + end) / 2;

            if (x==arr[mid]) {
                return mid;
            } else if (x>arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        Scanner sc = new Scanner(System.in);
        int element = sc.nextInt();
        int index = binarySearch(input, element);
        System.out.println(index);

    }
}
