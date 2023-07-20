package datastructure;

import java.util.*;

public class RandomBall {

    public static  int randomBall(int[] arr,int n,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer max=Integer.MIN_VALUE;
        for(int i=0;i<= arr.length-k;i++){
            for(int j=i;j<i+k;j++){
                if(arr[j]>max){
                    max=arr[j];
                }
                System.out.print(arr[j]+ " ");
            }
            System.out.println();
            if(map.containsKey(max)){
                map.put(max,map.get(max)+1);
            }else{
                map.put(max,1);
            }
            max=Integer.MIN_VALUE;
        }
        Integer maxValue=Integer.MIN_VALUE;
        Integer key = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> e:entrySet){
            if(e.getValue()>maxValue){
                maxValue=e.getValue();
                key=e.getKey();
            }
        }
        return key;
    }
    public static void main(String[] args) {
        int arr[]={8,5,4,6,2,1};
        int ball = randomBall(arr, 6, 3);
        System.out.println(ball);
    }
}
