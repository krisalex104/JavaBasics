package recursion.assignment;

public class ReplacePi {
    public static String replace(String input){
       if(input.length()<=1){
           return input;
       }

       if(input.charAt(0) == 'p' && input.charAt(1) == 'i'){
           return "3.14" + replace(input.substring(2));
       }
           return input.charAt(0)+replace(input.substring(1));
    }

    public static String replaceCharacter(String input, char c1, char c2) {
        if(input.length()==0){
            return input;
        }
        String ans="";
        if(input.charAt(0)==c1){
            ans=c2+ans;
        }else{
            ans=input.charAt(0)+ans;
        }
        String smallAnswer=replaceCharacter(input.substring(1),c1,c2);

        return ans+smallAnswer;
    }
    public static void main(String[] args) {
        String replace = replace("xpixpi");
        System.out.println(replace);
        String abc = replaceCharacter("xabxda",'x','a');
        System.out.println(abc);
    }
}
