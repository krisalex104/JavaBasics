package arrays;

import java.util.Scanner;

public class PrintAllPairs {

    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static  void printAllPairs(int[] input){
        int length=input.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                System.out.println(input[i]+ "  " +input[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        printAllPairs(input);
    }
}
