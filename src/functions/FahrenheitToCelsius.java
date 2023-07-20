package functions;

import java.util.Scanner;

public class FahrenheitToCelsius {

    public static void printFahrenheitTable(int start, int end, int step) {
        int i, C;
        for (i = start; i <= end; i = i + step) {
            C = ((i - 32) * 5) / 9;
            System.out.println(i + "\t" + C);
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int e=sc.nextInt();
        int g=sc.nextInt();
        printFahrenheitTable(s,e,g);
    }
}
