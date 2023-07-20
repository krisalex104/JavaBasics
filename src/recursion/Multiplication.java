package recursion;

public class Multiplication {

    public static int multiplyTwoIntegers(int m, int n){
        if(n==0){
            return 0;
        }
        int a = multiplyTwoIntegers(m, (n - 1)) + m;
        return a;

    }
    public static void main(String[] args) {
        int m = multiplyTwoIntegers(3, 5);
        System.out.println(m);
    }
}
