package recursion;

public class CheckNumber {

    public static boolean checkNumber(int[] input, int x) {
        int length= input.length;
        if(length>1){
            if(input[0]==x){
                return true;
            }else{
                int []smallInput=new  int[input.length-1];
                for(int i=1;i<input.length;i++){
                    smallInput[i-1]=input[i];
                }
                boolean b = checkNumber(smallInput, x);
                return b;
            }
        }else {
           return false;
        }
    }

    public static boolean checkNumberBetter(int []input,int number,int startIndex){
        int length=input.length;
        if(length>1){
            if(input[startIndex]==number){
                return true;
            }else{
                boolean b = checkNumberBetter(input, number, startIndex + 1);
                return b;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int []input={4,5,6,7,2,3};
        boolean b = checkNumber(input, 9);
        System.out.println(b);
        boolean b1 = checkNumberBetter(input, 7, 0);
        System.out.println(b1);
    }
}
