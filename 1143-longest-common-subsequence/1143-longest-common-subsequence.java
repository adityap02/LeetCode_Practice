class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //DP Top Down
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i=1; i<l1+1; i++){
            for (int j=1; j<l2+1; j++){
                //if Character Match, update value to 1+ diagonal up column (previous char from both str)
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //else max Subsequence from Upper of left cell (till previous char of one or another string)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];

    }
}