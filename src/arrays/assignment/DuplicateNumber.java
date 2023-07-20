package arrays.assignment;

import java.util.Scanner;

public class DuplicateNumber {
        public static int[] takeInput(){
            Scanner sc=new Scanner(System.in);
            int size=sc.nextInt();
            int[] input=new int[size];
            for(int i=0;i<size;i++){
                input[i]=sc.nextInt();
            }
            return input;
        }

        public static int returnDuplicate(int[] arr){
            int i = 0;

            while(i<arr.length) {
                int temp=arr[i];
                boolean ans = false ;
                for(int j=0;j<arr.length;j++) {
                    if(i==j) {
                        continue;
                    }else {
                        if(temp == arr[j])
                        {
                            ans = true  ;
                            break ;
                        }
                    }
                }

                if(ans)
                {
                    return arr[i] ;
                }
                i++ ;
            }
            return -1 ;
        }
        public static void main(String[] args) {
            int[] input = takeInput();
            int unique = returnDuplicate(input);
            System.out.println(unique);
        }
}
