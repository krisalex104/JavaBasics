package operator.assignment;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int reverse=0;
        while(n!=0){
        int remainder=n%10;
        reverse=reverse*10+remainder;
        System.out.print(remainder);
        n=n/10;
        }
        System.out.println();
        System.out.println(reverse);
        System.out.println();

        for( ;n != 0; n=n/10)
        {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
        }
        System.out.println(reverse);
    }
}
