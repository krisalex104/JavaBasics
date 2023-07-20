package operator.assignment;

import java.util.Scanner;

public class DecimalToBinary1 {
    public static void binary(int num){
        if (num==0)
        {
            System.out.print("0");
            return;
        }
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        binary(n);
    }
}
