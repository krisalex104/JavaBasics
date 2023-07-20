package recursion;

import java.util.HashMap;
import java.util.Set;

public class FindAllIndices {


    public static int[] allIndexes(int input[], int x) {
        int[] ints = allIndexes(input, x, 0);
        return ints;

    }

    private static int[] allIndexes(int input[], int x, int startIndex) {

        if (startIndex==input.length) {
           return  new int [0];
        }

        int[]  smallAnswer=  allIndexes(input,x,startIndex+1);

        if(input[startIndex]==x){
            int []ans=new int[smallAnswer.length+1];
            ans[0]=startIndex;
            for(int i=0;i<smallAnswer.length;i++){
                ans[i+1]=smallAnswer[i];
            }
            return ans;
        }else
            return smallAnswer;

    }

   public static int[] allIndexesBetter(int []arr ,int x){
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<arr.length;i++){
           if(arr[i]==x){
               map.put(i,arr[i]);
           }
       }
       Set<Integer> integers = map.keySet();
       int [] array=new int[integers.size()];
       int index=0;
       for(int i:integers){
           array[index]=i;
           index++;
       }
       return array;
   }

    public static void main(String[] args) {
        int []input={2,4,2,5,6,2,3,2};
        int[] ints = allIndexes(input, 2);
       for(int i=0;i<ints.length;i++){
           System.out.print(ints[i] + " ");
       }
        System.out.println();
        System.out.println();
        int[] better = allIndexesBetter(input, 2);
        for(int i=0;i<better.length;i++){
            System.out.print(better[i] + " ");
        }
    }
}
