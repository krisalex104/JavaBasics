package test1;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static int findGCD(int x, int y)
    {
        while(y != 0)
        {
            if(x > y)
            {
                x =x - y;
            }
            else
            {
                y = y - x;
            }
        }
        return x;
    }
    public static void main(String[] args) {
        int x, y,t, gcd = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        t= sc.nextInt();

        System.out.print("Enter the First Number: ");
        x = sc.nextInt();
        System.out.print("Enter the Second Number: ");
        y = sc.nextInt();

        if(t>0){
            for(int i=1; i<=t;i++){
                gcd = findGCD(x, y);
                System.out.println(gcd);
            }
        }
    }
}
