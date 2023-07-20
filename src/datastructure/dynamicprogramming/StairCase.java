package datastructure.dynamicprogramming;

public class StairCase {
    public static long staircase(int n) {
        if (n <= 1)
            return 1;

        if(n==2){
            return 2;
        }

        return staircase(n - 1) + staircase(n - 2)+staircase(n-3);
    }

    public static long starCaseM(int n){
        int []storage=new int[n+1];
        for(int i=0;i<=n;i++){
            storage[i]=0;
        }
        return stairCaseM(n,storage);
    }

    public static long stairCaseM(int n,int[] storage){
        if(n==0||n==1){
            storage[n]=1;
            return storage[n];
        }

        if(n==2){
            storage[n]=2;
            return storage[n];
        }

        if(storage[n]!=0){
            return storage[n];
        }

        storage[n]= (int) (stairCaseM(n-1,storage)+ stairCaseM(n-2,storage)+ stairCaseM(n-3,storage));
        return storage[n];
    }

    public static  int stairCaseDp(int n){
        if(n<=1)
            return 1;
        if(n==2)
            return 2;

        int []storage=new int[n+1];
        storage[0]=1;
        storage[1]=1;
        storage[2]=2;

        for(int i=3;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2]+storage[i-3];
        }
        return storage[n];
    }



    public static void main(String[] args) {
        int n=4;
        System.out.println(staircase(n));
        System.out.println(starCaseM(n));
        System.out.println(stairCaseDp(n));
    }
}
