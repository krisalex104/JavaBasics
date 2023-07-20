package test2;

public class MinimumLengthWord {
    public static String minLengthWord(String input){
        String[] split = input.split(" ");
        String smallest=split[0];
        for (int i=1;i<split.length;i++){
            if(split[i].length()<smallest.length()){
               smallest=split[i];
            }
        }
       return smallest;
    }
    public static void main(String[] args) {
        String str="this is test string";
        String s = minLengthWord(str);
        System.out.println(s);
    }
}
