package string;

import java.util.Arrays;
import java.util.Scanner;

public class StringPermutation {

    public static boolean stringPermutation(String str1, String str2) {
        int[] arr = new int[500];
        for (int i = 0; i < str1.length(); i++) {
            arr[(int) str1.charAt(i)] += 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            arr[(int) str2.charAt(i)] -= 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
    public static boolean isPermutation(String str1, String str2) {
        //Your code goes here
        int m=str1.length();
        int n=str2.length();
        if(m!=n){
            return false;
        }
        char ch1[]=str1.toCharArray();
        char ch2[]=str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<n;i++)
        {
            if(ch1[i]!=ch2[i])
                return false;
        }
        return true;
    }

    static void printallPermutns(String str, String str2)
    {
        // check if string is empty or null
        if (str.length() == 0)
        {
            System.out.print(str2 + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++)
        {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String str3 = str.substring(0, i) + str.substring(i + 1);
            // Recursive call
            printallPermutns(str3, str2 + ch);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean permutation = isPermutation(str1, str2);
        System.out.println(permutation);
        boolean b = stringPermutation(str1, str2);
        System.out.println(b);

        String s = "cat";
        printallPermutns(s, "");
    }
}
