package recursion.assignment;

public class BinarySearch {

    public static int binarySearch(int[] arr, int x) {
        //Your code goes here
        if(arr.length==0){
            return -1;
        }
        return binarySearch(arr, x, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int x,int startIndex,int endIndex) {
        //Your code goes here
        if(startIndex>endIndex){
            return -1;
        }

           int mid=(startIndex+endIndex)/2;

           if(arr[mid]==x){
               return mid;
           } else if (x>arr[mid]) {
               return binarySearch(arr,x,mid+1,endIndex);
           }else{
               return binarySearch(arr,x,startIndex,mid-1);
           }
    }

    public static void main(String[] args) {
        int []arr={2,2,3,6,7,8};
        int i = binarySearch(arr, 3);
        System.out.println(i);
    }
}
