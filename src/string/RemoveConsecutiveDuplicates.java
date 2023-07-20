package string;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicates(String str) {
        //Your code goes here
        int n=str.length();
        String str2="";
        if(n>1){
            str2+=str.charAt(0);
            for(int i=1;i<n;i++){
                if(str2.charAt(str2.length()-1)!=str.charAt(i)){
                    str2+=str.charAt(i);
                }
            }
        }else{
            str2+=str.charAt(0);
        }

        return str2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String s = removeConsecutiveDuplicates(str);
        System.out.println(s);
    }
}
