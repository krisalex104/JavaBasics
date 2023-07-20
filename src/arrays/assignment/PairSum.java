package arrays.assignment;

import java.util.Scanner;

public class PairSum {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static  int findPairSum(int[] arr,int x){
        int count=0;
        for(int i=0;i< arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                int sum=arr[i]+ arr[j];
                if(sum==x){
                    count++;
                }
            }
        }
        return count;
    }

    public static  int findTripletSum(int[] arr,int x){
        int sum=0,temp=0,count=0;
        for(int i=0;i< arr.length;i++){
            temp=arr[i];
            for(int j=i+1;j< arr.length;j++){
                for(int k=j+1;k< arr.length;k++){
                    sum=temp+ arr[j]+arr[k];
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
//        int pairSum = findPairSum(input, sum);
//        System.out.println(pairSum);
        int tripletSum = findTripletSum(input, sum);
        System.out.println(tripletSum);
    }
}
