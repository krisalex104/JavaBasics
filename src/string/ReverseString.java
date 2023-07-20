package string;

public class ReverseString {
    public static void main(String[] args) {
        String str="abcde";
        String reverse="";
        String reverseString="";
        for(int i=str.length()-1;i>=0;i--){
            reverse+=str.charAt(i);
        }
        System.out.println();
        for(int i=0;i<str.length();i++){
            reverseString=str.charAt(i)+reverseString;
        }
        System.out.println(reverse);
        System.out.println(reverseString);
    }
}
