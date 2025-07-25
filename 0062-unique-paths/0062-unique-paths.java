class Solution {
    public int uniquePaths(int m, int n) {
        //At each step calulating the number of ways to reach the up box + the left box ( sum of both)
        //is the number of ways to reach current box
        int[][] dp = new int[m][n];
        // First row and first column can only be reached in one way
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}