class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //Ierate from start to end. At each iteration, use a second for loop to iterate from 0 up until i 
        //(all the elements before i). For each element before i, check if that element is smaller than nums[i]. 
        //If so, set dp[i] = max(dp[i], dp[j] + 1).
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }//Time complexity: O(N ^2)
}