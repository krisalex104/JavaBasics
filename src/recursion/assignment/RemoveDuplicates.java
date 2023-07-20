package recursion.assignment;

public class RemoveDuplicates {
    public static String removeConsecutiveDuplicates(String s) {
       if(s.length()<=1){
           return s;
       }

       if(s.charAt(0)==s.charAt(1)){
           return removeConsecutiveDuplicates(s.substring(1));
       }else {
           return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
       }

    }


    public static void main(String[] args) {
        String consecutiveDuplicates = removeConsecutiveDuplicates("aabccbdd");
        System.out.println(consecutiveDuplicates);
    }
}
