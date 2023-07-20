package operator.assignment;

import java.util.Scanner;

public class TermsOfAp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int count=0;
        for(int i=1;;i++){

            if(count==n)
                break;
            int ap=3*i+2;

            if(ap%4!=0){
                System.out.println(ap);
                count++;
            }
        }
    }
}
