package recursion.assignment;

public class RemoveX {
    public static String removeX(String input){
        // Write your code here
        if(input.length()<=1){
            if(input.charAt(0)=='x'){
                return "";
            }else{
                return input;
            }
        }
        if(input.charAt(0)=='x'){
            return "" + removeX(input.substring(1));
        }
        return input.charAt(0)+removeX(input.substring(1));

    }

    public static String removeP(String input){

        if(input.length()==0){
            return input;
        }
        String ans="";
        if(input.charAt(0)!='p'){
            ans= ans+input.charAt(0);

        }
       String smallAnswer=removeP(input.substring(1));
        return ans+smallAnswer;

    }

    public static void main(String[] args) {
        String removeX = removeX("xaxbacx");
        String removeP = removeP("papbacp");
        System.out.println(removeX);
        System.out.println(removeP);
    }
}
