package arrays;

import java.util.Scanner;

public class LinearSearch {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static int linearSearch(int[] arr, int x) {
        int size= arr.length;
        int position=-1;
        for(int i=0;i<size;i++){
            if(arr[i]==x){
                position=i;
                return position;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        Scanner sc=new Scanner(System.in);
        int numberTobeSearched=sc.nextInt();
        int position = linearSearch(input, numberTobeSearched);
        System.out.println(position);
    }
}
