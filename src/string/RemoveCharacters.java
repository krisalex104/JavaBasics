package string;

public class RemoveCharacters {
    public static void main(String[] args) {
        String str="abacds";
        char ch='a';
        String s=String.valueOf(ch);

        String a = str.replaceAll(s, "");
        System.out.println(a);
        String str2="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=ch){
                str2+=str.charAt(i);
            }
        }
        System.out.println(str2);
    }
}
