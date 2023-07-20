package recursion;

public class CountZero {
    public static int countZerosRec(int input){
       if(input==0){
           return 1;
       } else if (input<10) {
         return 0;  
       } else if (input%10==0) {
           return countZerosRec(input/10) +1;
       }else {
           return countZerosRec(input/10);
       }
    }

    public static void main(String[] args) {
        int countZerosRec = countZerosRec(10201);
        System.out.println(countZerosRec);
    }
}
