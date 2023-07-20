package pattern;

import java.util.Scanner;

public class SquarePattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        int k=1;
        while(k<=n){
            int l=1;
            while (l<=n){
                System.out.print("*");
                l++;
            }
            System.out.println();
            k++;
        }
    }
}
