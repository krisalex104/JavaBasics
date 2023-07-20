package datastructure.dynamicprogramming;


/**
 * You are given a set of N integers.
 * You have to return true if there exists a subset that sum up to K, otherwise return false.
 */
public class SubsetSum {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, an empty subset can be formed
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If there are no elements in the set, no subset can be formed
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // Populate the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the current sum, exclude it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Check if either including or excluding the current element leads to a subset sum
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Return the result stored in the last cell of the dp array
        return dp[n][sum];

    }
    public static void main(String[] args) {

    }
}
