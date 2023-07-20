package datastructure.dynamicprogramming;

public class CountBalancedBinaryTrees {

    //below solution through normal recursion
    public static long balancedBTs(long n){

        int mod=(int)Math.pow(10,9)+7;
        return balancedBTs(n,mod);

    }

    public static long balancedBTs(long n,int mod){

        if(n==0||n==1){
            return 1;
        }
        long x=balancedBTs(n-1);
        long y=balancedBTs(n-2);
        return (x*x +2*x*y)%mod;
    }


    //below solution through memoization

    public static long balancedBinaryTreesM(int h){
        long []storage=new long[h+1];
        return balancedBinaryTreesM(h,storage);
    }

    public static long balancedBinaryTreesM(int h,long []storage){
        if(h==0 || h==1){
            storage[h]=1;
            return storage[h];
        }

        if(storage[h]!=0){
            return storage[h];
        }

        long x=balancedBinaryTreesM(h-1,storage);
        long y=balancedBinaryTreesM(h-2,storage);

        storage[h]=(x*x)+2*x*y;
        return storage[h];

    }

    //below solution through dynamic programming
    public static long balancedBTsDP(long h){
        long []storage=new long[(int) (h+1)];
       return balancedBTsDP(h,storage);
    }

    public static long balancedBTsDP(long h, long []storage){

        if(h<=0){
            return 1;
        }
        storage[0]=1;
        storage[1]=1;
        for(int i=2;i<=h;i++){
            long x=storage[i-1];
            long y=storage[i-2];
            storage[i]=x*x + 2*x*y;
        }
        return storage[(int) h];
    }

    public static int balancedTreesOfHeightH(int n){

        int storage[] = new int[n+1];

        storage[0] = 1;
        storage[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            int h1 = storage[i-1];
            int h2 = storage[i-2];

            int m = (int)Math.pow(10,9) + 7;
            long res1 = ((long)h1*h1);
            long res2 = ((long)h1*h2*2);

            int val1 = (int)(res1%m);
            int val2 = (int)(res2%m);

            storage[i] = (val1 + val2)%m;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        long x=4;
        System.out.println(balancedBTs(x));
        System.out.println(balancedBTsDP(x));
        System.out.println(balancedTreesOfHeightH(4));
        System.out.println(balancedBinaryTreesM(4));
    }
}
