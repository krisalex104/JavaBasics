package recursion.assignment;

public class StringToInteger {

    public static int convertStringToInt(String input){
        if(input.length()==1){
           return input.charAt(0)-'0';
        }
        int ans=convertStringToInt(input.substring(1));
        int x=input.charAt(0)-'0';
         x= x*(int)Math.pow(10,input.length()-1)+ans;
        return x;
    }

    public static void main(String[] args) {
        int toInt = convertStringToInt("1234");
        System.out.println(toInt);
    }
}
