class Solution {
    public int coinChange(int[] coins, int amount) {
        //Dynamic programming - Bottom up
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    //Here we are checking that to make amount (for ex) 6 -> is DP[6] is less or
                    //or DP[6-2] +1 -> whatever best # of coins to get amount 4 + coin of val 2   
                    //-> 2 is current coin- will check for each coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}