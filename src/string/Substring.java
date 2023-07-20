package string;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        String str="coding";
        System.out.println(str.substring(2));
        System.out.println(str.substring(6));
        System.out.println(str.substring(4));
        //System.out.println(str.substring(7));

        String a="coding";
        for(int i=2;i<4;i++)
        {
            System.out.print(a.substring(i));
        }
        System.out.println();
        for(int i=2;i<5;i++)
        {
            System.out.print(a.substring(i-2,i+1));
        }

        Scanner sc=new Scanner(System.in);
    }
}
