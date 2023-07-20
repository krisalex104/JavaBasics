package pattern;

import java.util.Scanner;

public class TriangularPattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        int k=1;
        while (k<=n){
            int l=1;
            while (l<=k){
                System.out.print(l);
                l++;
            }
            System.out.println();
            k++;
        }
    }
}
