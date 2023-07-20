package practiceproblems;

import java.util.Scanner;

public class TotalSalary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int basicSalary=sc.nextInt();

        char grade = sc.next().charAt(0);

        double hra=(0.2d * basicSalary);
        double da= (0.5d * basicSalary);
        double pf= (0.11d * basicSalary);
        int allowance;

        if(grade=='A'){
            allowance=1700;
        }else if(grade=='B'){
            allowance = 1500;
        }else{
            allowance = 1300;
        }

        double totalSalary = basicSalary + hra;
        totalSalary += da;
        totalSalary += allowance;
        totalSalary -= pf;

        System.out.println(Math.round(totalSalary));
    }
}
