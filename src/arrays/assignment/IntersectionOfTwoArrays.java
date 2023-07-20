package arrays.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfTwoArrays {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }
    public static void printInterSectionElement(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            int temp=arr1[i];
            for(int j=0;j<arr2.length;j++){
                if(temp==arr2[j]){
                    System.out.print( arr1[i] + " ");
                    arr2[j]=Integer.MIN_VALUE;
                    break;
                }
            }
        }
        List<Integer> intersectionList = new ArrayList<>();

        intersectionList.toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        printInterSectionElement(arr1,arr2);
    }
}
