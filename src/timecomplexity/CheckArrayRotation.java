package timecomplexity;

public class CheckArrayRotation {
    public static int arrayRotateCheck(int[] arr){
        //Your code goes here
        int index=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<arr[i-1])
            {
                index=i;
            }
        }
        return index;
    }
}
