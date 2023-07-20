package practiceproblems;

import java.util.Scanner;

public class AverageMarks {
    public static  void  main(String args[]){

        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        char c=name.charAt(0);
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int average=(m1+m2+m3)/3;
        System.out.println(c);
        System.out.println(average);

    }
}
