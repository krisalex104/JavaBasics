package string;

import java.util.Scanner;

public class CountAllWords {
    public static int countWords(String str) {
        int flag = 0;
        int count = 0;
        int i = 0;

        while (i < str.length()) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\t') {
                flag = 0;
            }else if (flag == 0) {
                flag = 1;
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = countWords(str);
        System.out.println(count);
    }
}
