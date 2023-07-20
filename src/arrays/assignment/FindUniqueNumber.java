package arrays.assignment;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FindUniqueNumber {
    public static int[] takeInput(){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] input=new int[size];
        for(int i=0;i<size;i++){
            input[i]=sc.nextInt();
        }
        return input;
    }

    public static int returnUnique(int[] arr){
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

            if(!ans)
            {
                return arr[i] ;
            }
            i++ ;
        }
        return -1 ;
    }

    public static int findUnique(int []arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1 );
            }
        }
        Set<Integer> integers = map.keySet();
        for (int i:integers){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] input = takeInput();
        int unique = returnUnique(input);
        System.out.println(unique);
        int unique1 = findUnique(input);
        System.out.println(unique1);
    }
}
