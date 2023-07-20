package recursion;

public class CheckSorted {
    public static boolean checkSorted_1(int []input){
        if(input.length==0 || input.length==1){
            return true;
        }
        int []smallInput=new int[input.length-1];
        for(int i=1;i<input.length;i++){
            smallInput[i-1]=input[i];
        }

        boolean b = checkSorted_1(smallInput);
        if(!b){
            return false;
        }
        if(!(input[0]<input[1])){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkSorted_2(int []input){

        if(input.length<=1){
            return true;
        }

        if(input[0]>input[1]){
            return false;
        }
        int []smallInput=new int[input.length-1];
        for(int i=1;i<input.length;i++){
            smallInput[i-1]=input[i];
        }

        boolean b = checkSorted_1(smallInput);
        return b;
    }

    public static  boolean checkSortedBetter(int []input,int startIndex){
        if(startIndex>=input.length-1){
            return true;
        }

        if(input[startIndex]>input[startIndex +1]){
            return false;
        }

        boolean b = checkSortedBetter(input, startIndex + 1);
        return b;
    }

    public static void main(String[] args) {
        int input[]={2,8,7,3,9};
        boolean b = checkSorted_1(input);
        System.out.println(b);
        boolean b1 = checkSorted_2(input);
        System.out.println(b1);
        boolean b2 = checkSortedBetter(input, 0);
        System.out.println(b2);
    }
}
