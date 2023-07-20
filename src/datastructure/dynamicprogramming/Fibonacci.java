package datastructure.dynamicprogramming;

public class Fibonacci {

    //this method takes O(2^n) time to give results because
    // of same redundant function calls , we can save the redundant call by storing
    //the calculated value of the function call which decreases the time complexity.
    public static int fib(int n){
        if(n==0||n==1){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    //this method for fixing above time complexity issue
    //this method takes  array of size n+1 and initializes all the value in
    // the array with -1 and recursively call the fibMemoization(n,storage),
    // this technique called as memoization, and it follows top-down approach;
    public static int fibMemoization(int n){
        int []storage=new int[n+1];
        for(int i=0;i<=n;i++){
            storage[i]=-1;
        }

        return fibMemoization(n,storage);

    }

    //this method will calculate the value according to n and store in the array , and each call
    //it checks that value is present in the array or not for making redundant calls.
    public static  int fibMemoization(int n,int []storage){
        if(n==0||n==1){
            storage[n]=n;
            return storage[n];
        }

        //here we have to check first that for value n , we have already calculated the
        //result or not , so that we don't have to make the redundant calls again and again

        if(storage[n]!=-1){
            return storage[n];
        }
        storage[n]=fibMemoization(n-1,storage)+fibMemoization(n-2,storage);
        return storage[n];
    }

    //We can also solve this problem with dynamic programming ,by following bottom up approach
    public static  int fibDynamicProgramming(int n){
        int []storage=new int[n+1];
        storage[0]=0;
        storage[1]=1;
        for(int i=2;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];
    }
    public static void main(String[] args) {
        System.out.println(fibDynamicProgramming(40));
        System.out.println(fibMemoization(40));
        System.out.println(fib(40));

    }
}
