package operator;

import java.util.Scanner;

public class ContinueDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int j=1;
        while(j<=n){
            if(j==5){
                j++;
                continue;
            }
            System.out.println(j);
            j++;
        }

        System.out.println("******************");

        for(int i=1;i<=n;i++){
           if(i==6){
               continue;
           }
            System.out.println(i);
        }

        int i=0;
        for(;;)
        {
            if(i==5)
                break;
            System.out.print(i);
            i++;
        }
         i=7;
        for( i=7;i!=0;i--)
        {
            System.out.print(i--);
        }
    }
}
