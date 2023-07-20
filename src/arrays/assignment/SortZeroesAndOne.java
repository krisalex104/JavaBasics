package arrays.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class SortZeroesAndOne {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static void sortZeroAndOne(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("  ");

        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                count++;
            }
        }
        for(int i=0;i<count;i++)
        {
            arr[i]=0;
        }
        for(int i=count;i<arr.length;i++)
        {
            arr[i]=1;
        }
    }

    public static void sortZero(int[] arr){
        int i =0;
        int j = arr.length-1 ;
        while(i < j){
            if(arr[i] == 0 && arr[j] == 1) {
                i++ ; j-- ;
                continue  ;
            }else{
                if(arr[i] == 0 && arr[j] == 0) {
                    i++ ;
                    continue  ;
                }else if(arr[i] == 1 && arr[j] == 1){
                    j-- ;
                    continue;
                }else if(arr[i] == 0 && arr[j] == 1){
                    i++ ; j-- ;
                    continue  ;
                }else{
                    int temp =arr[i] ;
                    arr[i] = arr[j] ;
                    arr[j] = temp ;
                    i++ ; j-- ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        sortZeroAndOne(input);
    }
}
