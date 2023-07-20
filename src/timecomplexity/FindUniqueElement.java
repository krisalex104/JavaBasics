package timecomplexity;

public class FindUniqueElement {

    public static int findUnique(int[] arr) {
        //Your code goes here
        int unique=0;
        if(arr.length==1){
            return arr[0];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    unique=arr[i];
                }
            }
        }
        return unique;
    }

    public static int findUniqueElement(int[] arr){
        int ans=arr[0];
        for(int  i=1;i<arr.length;i++)
        {
            ans=ans^arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
       int []arr={2,3,2,4,3};
        int unique = findUnique(arr);
        System.out.println(unique);
        int uniqueElement = findUniqueElement(arr);
        System.out.println(uniqueElement);
    }
}
