package datastructure.dynamicprogramming;

import java.util.Arrays;

/**
 * A thief robbing a store can carry a maximal weight of W into his knapsack.
 * There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V,
 * that the thief can steal?
 */

public class KnapSack01 {

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        //Your code goes here
        return knapsack(weights, values, n, maxWeight,0);

    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight,int i) {
        if(i==weight.length || maxWeight==0){
            return 0;
        }

        if(weight[i]>maxWeight){
            return knapsack(weight, value, n, maxWeight, i+1);
        }else{
            //include
            int opt1=value[i]+ knapsack(weight, value, n, maxWeight-weight[i], i+1);

            //don't include
            int opt2=knapsack(weight, value, n, maxWeight, i+1);
            return Math.max(opt1, opt2);
        }
    }

    static int knapsackM(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */
        int[][] memo = new int[weight.length][maxWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return knapsackHelper(weight, value, maxWeight, 0, memo);

    }

    static int knapsackHelper(int[] weights, int[] values, int capacity, int currentIndex, int[][] memo) {
        if (capacity < 0 || currentIndex >= weights.length) {
            return 0;
        }

        if (memo[currentIndex][capacity] != -1) {
            return memo[currentIndex][capacity];
        }

        int value1 = 0;
        if (weights[currentIndex] <= capacity) {
            value1 = values[currentIndex] + knapsackHelper(weights, values, capacity - weights[currentIndex], currentIndex + 1, memo);
        }

        int value2 = knapsackHelper(weights, values, capacity, currentIndex + 1, memo);

        int maxValue = Math.max(value1, value2);
        memo[currentIndex][capacity] = maxValue;

        return maxValue;
    }

    static int knapsackDp(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */
        int[][] dp = new int[n+1][maxWeight+1];

        for (int i=n-1;i>=0;i--)
        {
            for (int w=0;w<=maxWeight;w++)
            {
                if (weight[i]<=w)
                {
                    int ans1=dp[i+1][w];
                    int ans2=dp[i+1][w-weight[i]] + value[i];
                    dp[i][w]=Math.max(ans1, ans2);
                }
                else
                {
                    dp[i][w]=dp[i+1][w];
                }
            }
        }
        return dp[0][maxWeight];

    }
    public static void main(String[] args) {

    }
}
