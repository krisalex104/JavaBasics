package recursion;

import java.util.HashMap;

public class LastIndex {
    public static int lastIndex(int input[], int x) {
        int lastIndex = lastIndex(input, x, 0);
        return lastIndex;
    }

    private static int lastIndex(int input[], int x,int startIndex) {
        int lastIndex = -1;
//        if(startIndex<input.length-1 && input.length>0){
//            if(input[startIndex]==x){
//                lastIndex=startIndex;
//            }
//            lastIndex = lastIndex(input, x, startIndex + 1);
//        }
//        if(lastIndex!=x){
//           if(input[startIndex]==x){
//               return startIndex;
//           }else{
//               return lastIndex;
//           }
//        }
//        return lastIndex;

        if(startIndex<0){
            return lastIndex;
        } else if (input[startIndex]==x) {
            lastIndex=startIndex;
        }else{
            lastIndex = lastIndex(input, x, startIndex + 1);
        }
       return lastIndex;
    }

    public  static int findLastIndex(int []arr,int x){
        HashMap<Integer,Integer> map=new HashMap<>();
        int lastIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                lastIndex=i;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args) {
        int []input={34 ,57, 82, 41, 65, 35,
                82, 27, 36 ,12, 6, 40, 66, 99, 25 ,
                29, 22, 25, 12, 24, 65, 15,
                5, 43, 28, 33, 76, 32, 13, 95, 22, 84,
                71, 23, 28, 7 ,65 ,94,
                18, 47, 9 ,42, 61, 73 };
        int x=61;
        int lastIndex = lastIndex(input, x);
        System.out.println(lastIndex);
        System.out.println();
        int lastIndex1 = findLastIndex(input, x);
        System.out.println(lastIndex1);
    }
}
