package functions;

public class test {
    public static int func(int a){
        a += 10;
        return a;
    }

    public static boolean isPrime(int x)
    {
        for(int i=2;i<x/2;i++)
        {
            if(x%i==0)
                return false;
        }
        return true;

    }

    public static int sum(int a,int b)
    {
        System.out.print("int sum ");
        return a+b;
    }
    public static long sum(long a,long b)
    {
        System.out.print("long sum ");
        return a+b;
    }

    public static double sum(double a,double b)
    {
        System.out.print("float sum ");
        return a+b;
    }

    public static void main(String[] args) {
        int a = 5;
        int func = func(a);
        System.out.println(a);
        System.out.println(isPrime(47));

        a=4;
        int b=5;
        System.out.println(sum(a,b));
        System.out.print(sum(5,4));
        System.out.print(sum(5.0,4.0));
    }
}
