package recursion;

public class PrintNumbers {

    public static void print(int n){
        //Write your code here
        if(n==0){
            return;
        }
        print(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        print(5);
    }
}
