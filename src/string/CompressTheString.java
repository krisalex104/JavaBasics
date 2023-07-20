package string;

public class CompressTheString {
    public static String getCompressedString(String str) {
        // Write your code here.
        String s = "";
        char ch = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ch == c) {
                count++;
            } else {
                if (count > 1) {
                    s = s + ch + count;
                }
                else{
                    s = s + ch;
                }
                count = 1;
            }
            ch = c;
        }

        if (count > 1)
            s = s + ch + count;
        else
            s = s + ch;

        return s;

    }

    public static String compressTheString(String str){
        int count=1;
        char ch=str.charAt(0);
        String compress="";
        for(int i=1;i<str.length();i++){
            char c=str.charAt(i);
            if(ch==c){
                count++;
            }else{
                if(count>1){
                    compress=compress + ch +count;
                }else {
                    compress=compress + ch;
                }
                count=1;
            }
            ch=c;
        }

        if(count>1){
            compress=compress + ch +count;
        }else {
            compress=compress + ch;
        }

        return compress;
    }

    public static void main(String[] args) {
       String str="xxxxxvvvsd";
        String compressedString = getCompressedString(str);
        System.out.println(compressedString);
        String s = compressTheString(str);
        System.out.println(s);
    }
}
