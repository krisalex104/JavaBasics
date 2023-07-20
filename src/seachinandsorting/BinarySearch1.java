package seachinandsorting;

import java.util.Scanner;

public class BinarySearch1 {
    static int binarySearch(int a[], int beg, int end, int val)
    {
        int mid;
        if(end >= beg)
        {
            mid = (beg + end)/2;
            if(a[mid] == val)
            {
                return mid+1;  /* if the item to be searched is present at middle */
            }
            /* if the item to be searched is smaller than middle, then it can only be in left subarray */
            else if(a[mid] < val)
            {
                return binarySearch(a, mid+1, end, val);
            }
            /* if the item to be searched is greater than middle, then it can only be in right subarray */
            else
            {
                return binarySearch(a, beg, mid-1, val);
            }
        }
        return -1;
    }
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        return input;
    }
    public static void main(String[] args) {
        int[] input = takeInput();
        Scanner sc = new Scanner(System.in);
        int element = sc.nextInt();
        int start=0;
        int end=input.length-1;
        int i = binarySearch(input, start, end, element);
        System.out.println(i);
    }
    }
