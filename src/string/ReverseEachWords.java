package string;

public class ReverseEachWords {
    public static String reverseEachWord(String input){
        int end=input. length() ;
        int i=input. length()-1;
        String output="" ;
        while(i>=0){
            if(input.charAt(i)==' ') {
                output =output + input. substring(i + 1,end)+ " ";
                end=i ;
            }
            i--;
        }
        output+=input.substring(i+1,end);
        return output;
    }

    public static String reverseEachWords(String str){
        String ans="";
        int currentWordStart=0;
        int i=0;
        for(;i<str.length();i++){
            if(str.charAt(i)==' '){
                //Reverse Current Word
                int currentWordEnd=i-1;
                String reversedWord="";
                for(int j=currentWordStart;j<=currentWordEnd;j++){
                    reversedWord=str.charAt(j)+reversedWord;
                }
                //Add it final String(ans)
                ans+=reversedWord+" ";
                currentWordStart=i+1;
            }
        }
        int currentWordEnd=i-1;
        String reversedWord="";
        for(int j=currentWordStart;j<=currentWordEnd;j++){
            reversedWord=str.charAt(j)+reversedWord;
        }
        ans+=reversedWord;
        return ans;
    }

    public static void main(String[] args) {
        String str="Welcome to Coding Ninjas";
        String reverse="";
        for(int i=0;i<str.length();i++){
            reverse=str.charAt(i) + reverse;
        }
        System.out.println(reverse);
        System.out.println("*************");
        String s = reverseEachWords(str);
        System.out.println(s);
    }
}
