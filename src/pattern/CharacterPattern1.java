package pattern;

import java.util.Scanner;

/**
 * for pattern
 *
 * ABCD
 * ABCD
 * ABCD
 * ABCD
 *
 */
public class CharacterPattern1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=1;j<=n;j++){
                System.out.print(ch);
                ch++;
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
                System.out.print((char)('A'+l-1));
                l++;
            }
            System.out.println();
            k++;
        }
    }
}
