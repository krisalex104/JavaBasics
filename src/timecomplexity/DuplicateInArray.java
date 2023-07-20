package timecomplexity;

import java.util.HashSet;

public class DuplicateInArray {

    public static int findDuplicate(int[] arr) {
        //Your code goes here
        int duplicate=0;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    duplicate= arr[i];
                }
            }
        }
        return duplicate;
    }

    public static int duplicate(int[] arr){
        HashSet<Integer> hashSet=new HashSet<>();
        int element=0;
        for(int i=0;i<arr.length;i++){
            if(!hashSet.add(arr[i])){
                element=arr[i];
            }
        }
       return element;
    }
    public static void main(String[] args) {
        int []arr={5,3,2,4,3};
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);
        int duplicate1 = duplicate(arr);
        System.out.println(duplicate1);
    }
}
