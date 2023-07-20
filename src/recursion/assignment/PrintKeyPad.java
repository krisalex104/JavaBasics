package recursion.assignment;

public class PrintKeyPad {

    public static void printKeypad(int input){
        // Write your code here
        printKeypad(input,"");

    }

    public static void printKeypad(int input,String outputSoFar){
      if(input==0){
          System.out.println(outputSoFar);
          return;
      }
        int n=input%10;
        int newInput=input/10;
        String helper = helper(n);
        for(int i=0;i<helper.length();i++){
            printKeypad(newInput,helper.charAt(i)+outputSoFar);
        }
    }

    private static String helper(int newN){
        if(newN==2)
            return "abc";
        if(newN==3)
            return "def";
        if(newN==4)
            return "ghi";
        if(newN==5)
            return "jkl";
        if(newN==6)
            return "mno";
        if(newN==7)
            return "pqrs";
        if(newN==8)
            return "tuv";
        if(newN==9)
            return "wxyz";
        else
            return "";
    }
    public static void main(String[] args) {
         printKeypad(234);
    }
}
