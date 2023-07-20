package timecomplexity;

import java.util.HashSet;

public class DuplicatesInArray {
    public static int findDuplicate(int[] arr) {
        //Your code goes here
        HashSet<Integer> hashSet=new HashSet<>();
        int element=0;
        for(int i=0;i<arr.length;i++){
            if(!hashSet.add(arr[i])){
                element=arr[i];
            }
        }
        return element;
    }
}
