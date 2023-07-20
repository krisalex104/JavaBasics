package datastructure.dynamicprogramming;

public class CountMinSquare {
    public static int countMinSquares(int N) {
        // Base case: If N is 0, no squares are required
        if (N == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        // Try all possible squares less than or equal to N
        for (int i = 1; i * i <= N; i++) {
            // Recursively find the count for the remaining N - i*i
            int count = countMinSquares(N - i * i);

            // Update the minimum count if a smaller count is found
            minCount = Math.min(minCount, count);
        }

        // Add 1 to the minimum count for the current N
        return minCount + 1;
    }

    //time complexity is O(n root n)
    public static int countMinSquareM(int n){
        int []arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=-1;
        }

        return countMinSquareM(n,arr);
    }

    public static int countMinSquareM(int n,int []arr){
        if(n==0){
            arr[n]=0;
            return arr[n];
        }

        if(arr[n]!=-1){
            return arr[n];
        }
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int count = countMinSquareM(n - i * i, arr);
            if(minCount>count){
                minCount=count;
            }
        }
        minCount++;
        arr[n]=minCount;
        return minCount;
    }

    public static int countMinSquareDp(int n){
        int []dp=new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int minAns=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int currAns=dp[i-j*j];
                if(currAns<minAns){
                    minAns=currAns;
                }
            }
            dp[i]=minAns+1;
        }
       return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(countMinSquares(7));
        System.out.println(countMinSquareM(7));
        System.out.println(countMinSquareDp(7));
    }
}
