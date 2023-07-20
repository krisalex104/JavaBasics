package practice;

import java.util.HashMap;

public class Test {

    //length of kDistinct substring
        public static int kDistinctChars(int k, String str) {
            // Write your code here
            int n=str.length();
            if(n*k==0){
                return 0;
            }

            int left=0;
            int right=0;
            HashMap<Character,Integer> map=new HashMap<>();
            int maxLength=0;
            int start=0;

            while(right<n){

                char c=str.charAt(right);
                map.put(c,right);

                right++;
                if(map.size()==k+1){
                    int minIndex=Integer.MAX_VALUE;
                    for(int index:map.values()){
                        minIndex=Math.min(minIndex, index);
                    }
                    map.remove(str.charAt(minIndex));
                    left=minIndex+1;
                }

                maxLength=Math.max(maxLength, right-left);
            }

            return maxLength;
        }



    public static void main(String[] args) {

    }
}
