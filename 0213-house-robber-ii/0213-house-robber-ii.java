class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        //Basically we will apply basic robber problem 2 times, once for array (0 to n-1) 
        //and other time for (1 to n) , Whichever give better result, return that
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }
    //We are doing basic robber problem here
    int helper(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }//O(n) BOTH

}