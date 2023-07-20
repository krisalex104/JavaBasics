package functions;

import java.util.Scanner;

public class PrintAllPrimeNumbers {
    public static boolean isPrime(int n){
        int d=2;
        while(d<n){
            if(n%d==0){
                return false;
            }
            d++;
        }
        return true;
    }
    public static void printTwoToN(int n){
        for(int i=2;i<n;i++){
            boolean prime = isPrime(i);
            if(prime){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printTwoToN(n);
    }
}
