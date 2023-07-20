package string;

import java.util.Scanner;

public class AllSubstring {

    public static void printSubString(String str){
        for(int start=0;start<str.length();start++){
            for(int end=start;end<str.length();end++){
                System.out.println(str.substring(start,end+1));
            }
        }
    }

    public static void printAllSubString(String str){

        for(int len=1;len<=str.length();len++){
            for(int start=0;start<=str.length()-len;start++){
                int end=start+len-1;
                System.out.println(str.substring(start,end+1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        printSubString(str);
        System.out.println("**************");
        printAllSubString(str);
    }
}
