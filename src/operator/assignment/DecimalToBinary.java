package operator.assignment;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int decimal=sc.nextInt();
        String binary=Integer.toBinaryString(decimal);
        System.out.println(binary);
    }
}
