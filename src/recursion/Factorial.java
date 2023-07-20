package recursion;

public class Factorial {

    public static  int fact(int n){
        if(n==0){
            return 1;
        }
        int answer=fact(n-1);
        return n*answer;
    }
    public static void main(String[] args) {
        int n=3;
        int answer = fact(n);
        System.out.println(answer);

    }
}
