package recursion.assignment2;

public class StairCase {
    public static int staircase(int n){

       if(n<0){
           return 0;
       } else if (n==0) {
           return 1;
       }

        int x=staircase(n-1);
       int y=staircase(n-2);
       int z=staircase(n-3);

       return x+y+z;

    }
    public static void main(String[] args) {
        int staircase = staircase(4);
        System.out.println(staircase);
    }
}
