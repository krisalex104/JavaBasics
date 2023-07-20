package arrays.assignment;

import java.util.Scanner;

public class TripletSum {

    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }
    public static  int findTripletSum(int[] arr,int x){
        int count=0;
        for(int i=0;i< arr.length-2;i++){
            for(int j=i+1;j< arr.length-1;j++){
                for(int k=j+1;k< arr.length;k++){
                    int sum=arr[i]+ arr[j] +arr[k];
                    if(sum==x){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=sc.nextInt();
        int[] input = takeInput();
        int pairSum = findTripletSum(input, sum);
        System.out.println(pairSum);
    }
}
