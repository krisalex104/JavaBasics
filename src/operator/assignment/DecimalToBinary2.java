package operator.assignment;

import java.util.Scanner;

public class DecimalToBinary2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println(n);
        }
        int binary=0;
        int index=0;
        String ans="";
        while (n>0){
            int remainder=n%2;
            ans+= remainder;
            System.out.print(remainder +"");
            n=n/2;
        }
        System.out.println();

        System.out.println(ans);
    }
}
