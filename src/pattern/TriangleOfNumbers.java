package pattern;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1;
        while(i<=n){
            int space=1;
            while(space<=n-i){
                System.out.print(" ");
                space++;
            }
            int j=1;
            int p=i;
            while(j<=i){
                System.out.print(p);
                j++;
                p++;

            }

           p=p-2;
            int l = 1 ;
            while(l<=i-1){
                System.out.print(p);
                p--;
                l++;
            }
            System.out.println();
            i++;
        }
    }
}
