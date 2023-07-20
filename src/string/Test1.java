package string;

public class Test1 {
   public static void main(String[] args) {
//        String a ="abcd";
//        String b="abcda";
//        System.out.println(a.compareTo(b));
//        System.out.println(b.compareTo(a));

       String a = "coding", b = "ninjas";
       if (a.contains("ing")) {
           a += b;
       } else {
           b += "ing";
       }
       System.out.print(b + a);
       System.out.println();
       String str1 = "abc";
       String str2 = new String("abc");
       System.out.println(str1 == str2);
       System.out.println(str1.equals(str2));

       String str3 = "abc";
       String str4 = "";
       System.out.println(str4);
       System.out.println(str3.contains(str4));

       System.out.println("**************");

       StringBuffer str5 = new StringBuffer("");
       for (int i = 0; i < 5; i++) {
           str5.append((char) ('a' + i));
       }
       System.out.println(str5);
   }

}
