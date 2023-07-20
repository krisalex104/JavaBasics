package recursion;

public class SumOfArray {

    public static int sum(int []input){
        if(input.length==1){
            return input[input.length-1];
        }
        int []smallInput=new  int[input.length-1];
        for(int i=1;i<input.length;i++){
            smallInput[i-1]=input[i];
        }
        int ans=sum(smallInput) + input[0];
        return ans;
    }

    public static int sumBetter(int []input,int startIndex){
        if(startIndex>=input.length-1){
            return input[input.length-1];
        }
        int ans=sumBetter(input,startIndex+1) + input[startIndex];
        return ans;
    }

    public static void main(String[] args) {
        int []input={1,4,5,6};
        int sum = sum(input);
        System.out.println(sum);

        int sumBetter = sumBetter(input, 0);
        System.out.println(sumBetter);
    }
}
