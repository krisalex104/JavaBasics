package datastructure.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUse {

    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output=new ArrayList<>();
        HashMap<Integer,Boolean> seen=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(!seen.containsKey(a[i])){
                output.add(a[i]);
                seen.put(a[i],true);
            }
        }
        return output;
    }

    public static int maxFrequencyNumber(int[] arr){
        HashMap<Integer,Integer> seen=new HashMap<>();
        for(int num:arr){
            if(seen.containsKey(num)){
                Integer value = seen.get(num);
                seen.put(num,value+1);
            }else{
                seen.put(num,1);
            }
        }
        Integer maxCount = Integer.MIN_VALUE, maxEle = arr[0];
        for (int i=0;i<arr.length;i++)
        {
            if (seen.get(arr[i])>maxCount)
            {
                maxCount=seen.get(arr[i]);
                maxEle=arr[i];
            }
        }
        return maxEle;
    }

    public static int PairSum(int[] input, int size) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int count = 0;

        for (int num : input) {
            int complement = -num;
            if (frequency.containsKey(complement)) {
                count += frequency.get(complement);
            }

            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static int PairSum2(int[] input, int size) {

        if (size==0)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:input)
        {
            if(map.containsKey(key))
            {
                map.put(key,map.get(key)+1);
            }
            else
            {
                map.put(key,1);
            }
        }
        int countPairs=0;
        for (Integer i: map.keySet())
        {
            if (map.containsKey(-i) && i!=0)
            {
                countPairs=countPairs+(map.get(i)*map.get(-i));
            }
        }
        countPairs=countPairs/2;
        if (map.containsKey(0))
        {
            int val=map.get(0);
            countPairs=countPairs+(val*(val-1))/2;
        }
        return countPairs;
    }

    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> seen=new HashMap<>();
        for(Integer num:arr1){
            seen.put(num,seen.getOrDefault(num,0)+1);
        }

        for(Integer num:arr2){
            if(seen.containsKey(num)){
                if(seen.get(num)!=0){
                    System.out.println(num);
                    seen.put(num,seen.get(num)-1);
                }
            }
        }

    }

    public static String uniqueChar(String str){
        String unique="";
        HashMap<String, Integer> seen=new HashMap<>();
        for(int i=0;i<str.length();i++){
            String s=""+str.charAt(i);
            if(seen.containsKey(s)){
                seen.put(s,seen.get(s)+1);
            }else{
                seen.put(s,1);
                unique=unique+str.charAt(i);
            }
        }
        return unique;

    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int num : arr) {
            numMap.put(num, true);
        }

        int maxLen = 0;
        int startElement = -1;

        for (int num : arr) {
            if (!numMap.containsKey(num - 1)) {
                int currentLen = 1;

                while (numMap.containsKey(num + 1)) {
                    num += 1;
                    currentLen += 1;
                }

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    startElement = num - currentLen + 1;
                }
            }
        }
        ArrayList<Integer> output=new ArrayList<>();
        if (maxLen == 1) {
            output.add(startElement);
            return output;
        } else {
            output.add(startElement);
            output.add( startElement + maxLen - 1);
            return output;
        }
    }

    public static int getPairsWithDifferenceK(int arr[], int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        if (k==0)
        {
            for (Integer i: frequency.keySet())
            {
                int val=frequency.get(i);
                count=count+(val*(val-1))/2;
            }
            return count;
        }

        for(int num:frequency.keySet()){
            int target1=k+num;
            int target2=num-k;

            if(frequency.containsKey(target1)){
                count+=(frequency.get(num)*frequency.get(k+num));
            }
            if(frequency.containsKey(target2)){
                count+=(frequency.get(num)*frequency.get(num-k));
            }
        }

        return count/2;
    }

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,maxLen=-1;
        for (int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if (sum==0)
            {
                maxLen=i+1;
            }
            if (map.containsKey(sum))
            {
                int prevIndex=map.get(sum);
                int currLen=i-prevIndex;
                if (currLen>maxLen)
                {
                    maxLen=currLen;
                }
            }
            else
            {
                map.put(sum,i);
            }
        }
        return maxLen;
    }
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        // Write your code here.
        ArrayList<Integer> a1=new ArrayList<>();
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<arr.size();i++){
            int num=arr.get(i);
            if(!map.containsKey(num)){
                map.put(num,true);
            }else{
                arr.remove(i);
                i--;
            }
        }

        return arr.size();
    }
    public static  void mapTest(){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("abc",1);
        map.put("bcd",1);
        map.put("cde",1);
        map.put("def",1);
        map.put("abc",2);
        map.put("bcd",1);

        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }

        if(map.containsKey("sdf")){
            System.out.println("Has sdf");
        }

        int size = map.size();
        System.out.println("Size of the Map "+size);

        Integer v= map.get("bkl");
        System.out.println(v);


        Integer abc = map.remove("abc");
        System.out.println(abc);

        size = map.size();
        System.out.println("Size of the Map "+size);

        Set<String> keySet = map.keySet();
        keySet.forEach(str->{
            System.out.println(str);
        });
    }
    public static void main(String[] args) {

//        int arr[]={1,2,3,4,55,3,2,6,7,1,2};
//        ArrayList<Integer> integers = removeDuplicates(arr);
//        integers.stream().forEach(unique->{
//            System.out.print(unique +" ");
//        });
//
//        System.out.println();
//        int max = maxFrequencyNumber(arr);
//        System.out.println(max);

        String uniqueChar = uniqueChar("aaaa");
        System.out.println(uniqueChar);


    }
}
