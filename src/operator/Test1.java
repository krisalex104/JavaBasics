package operator;

public class Test1 {
    public static void main(String[] args) {
        int a=10,b=20;
        int c=a&b;
        System.out.print(c);
        int d=a|b;
        System.out.print(d);
        int e=a^b;
        System.out.print(e);
        int f=c+d+e;
        System.out.print(~f);

        a=10;
        b=-20;
        System.out.print(a^b);
    }
}
