package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySum1 {

    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static void printSum(List<int[]> list){

        for(int i=0;i< list.size();i++) {
            int[] ints = list.get(i);
            int size = ints.length;
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum = sum + ints[j];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<testCases;i++){
            int[] input = takeInput();
            list.add(input);
        }
        printSum(list);

    }
}

