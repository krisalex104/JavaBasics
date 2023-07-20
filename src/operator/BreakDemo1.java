package operator;

import java.util.Scanner;

public class BreakDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        boolean divided=false;
        for(int d=2;d<n;d++){
            if(n%d==0){
                divided=true;
                break;
            }
        }
        if(divided){
            System.out.println("Not Prime");
        }else{
            System.out.println("Prime");
        }
    }
}
