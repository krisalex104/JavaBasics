package recursion;

public class SumofDigits {
    public static int sumOfDigits(int input){
      if(input==0){
          return 0;
      } else if (input<10) {
          return input;
      }else{
          int ld=input%10;
          int smallAnswer=sumOfDigits(input/10)+ld;
          return smallAnswer;
      }
    }
    public static void main(String[] args) {
        int sumOfDigits = sumOfDigits(555566666);
        System.out.println(sumOfDigits);
    }
}
