package pattern;

import java.util.Scanner;

/**
 * for pattern
 *
 D
 CD
 BCD
 ABCD
 *
 */
public class CharacterPattern3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=n;i>=1;i--){
            char ch=(char)('A'+ i-1);
            for(int j=n;j>=i;j--){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
