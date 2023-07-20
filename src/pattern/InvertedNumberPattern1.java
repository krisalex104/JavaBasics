package pattern;

import java.util.Scanner;

public class InvertedNumberPattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1;
        while(i<=n){
            int j=1;
            int k=n-i+1;
            while(j<=k){
                System.out.print(k);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
