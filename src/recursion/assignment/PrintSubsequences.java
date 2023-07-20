package recursion.assignment;

public class PrintSubsequences {

    public static void printSubsequences(String input){
        printSubsequences(input,"");
    }

    public static void printSubsequences(String input,String outputSoFar){
        if(input.length()== 0){
            System.out.println(outputSoFar);
            return;
        }

        //when  we choose not to  include first character in outputSoFar
        printSubsequences(input.substring(1),outputSoFar);

        //when  we choose  to  include first character in outputSoFar
        printSubsequences(input.substring(1), outputSoFar+input.charAt(0));
    }
    public static void main(String[] args) {
        printSubsequences("xyz");
    }
}
