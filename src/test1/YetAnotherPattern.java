package test1;

import java.util.Scanner;

public class YetAnotherPattern {

    public static void ninjaPuzzle(int n) {
        int row=n;
        for (int i= row; i>= 1; i--)
        {
            for (int j=row; j>i;j--)
            {
                System.out.print(" ");
            }
            for (int k=1;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] string = new String [sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < string.length; i++)
        {
            string[i] = sc.nextLine();
        }

        for(String str: string)
        {
            ninjaPuzzle(Integer.parseInt(str));
        }

    }

}
