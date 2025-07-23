public class Solution {
    int[] memo;

    public int climbStairs(int n) {
        //DP bottom up approach with memoisation
        // going from left to right building the solution
        // we will start with 3 stairs and then build our way up to n stairs
        //base case for upto 2 stairs is already provided 
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] =3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // Both SC & TC : O(n)
}