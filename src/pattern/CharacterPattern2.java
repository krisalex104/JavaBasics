package pattern;

import java.util.Scanner;

/**
 * for pattern
 *
 ABCD
 BCDE
 CDEF
 DEFG
 *
 */
public class CharacterPattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            char ch=(char)('A'+ i);
            for(int j=1;j<=n;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(int i=1;i<=n;i++){
            char ch=(char)('A'+ i-1);
            for(int j=1;j<=n;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
