package string;

import java.util.Scanner;

public class PalindromeString {
    public static boolean isPalindrome(String str){
        String reverse="";
        boolean p=false;
        for(int i=0;i<str.length();i++){
            reverse=str.charAt(i) + reverse;
        }
        if(reverse.equals(str)){
            p= true;
        }
        return p;
    }

    public static boolean palindrome(String str){
        int i=0;
        int j=str.length()-1;
        int mid;
        boolean b=true;
        if(str.length()%2==0){
            mid=str.length()/2 +1;
        }else{
            mid=str.length()/2;
        }
        while (i<=mid && j>=mid){
            if(str.charAt(i)!=str.charAt(j)){
                b=false;
            } else{
                i++;
                j--;
            }
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        boolean sd = isPalindrome(str);
        System.out.println(sd);
        boolean ab = palindrome(str);
        System.out.println(ab);

    }
}
