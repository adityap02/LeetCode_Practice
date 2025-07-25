class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Recursion :  At each index, you can either add the current number or subtract it.
        // Keep track of the current sum and the index.
        return helper(nums, target, 0, 0);
    }
    //O(2^n)
    private int helper(int[] arr, int target, int idx, int sum) {
        //base case : All elements of arr are scanned
        if (idx >= arr.length)
            return sum == target ? 1 : 0;
        //either we substract 
        int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
        //or we add
        int add = helper(arr, target, idx + 1, sum + arr[idx]);

        return subtract + add;
    }
}


    //DP SOlution Below O(n*m)
    //Use top-down DP with memoization to explore all ways of assigning + or - signs to each number to reach the target sum.
//      public class Solution {
//     private int[][] dp;      // DP memoization table
//     private int totalSum;    // Total sum of all elements (used to shift index to handle negative totals)

//     public int findTargetSumWays(int[] nums, int target) {
//         totalSum = 0;
//         for (int num : nums) totalSum += num;

//         // DP table size: [nums.length][range from -totalSum to +totalSum]
//         dp = new int[nums.length][2 * totalSum + 1];

//         // Initialize with sentinel value (Integer.MIN_VALUE means uncomputed)
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < 2 * totalSum + 1; j++) {
//                 dp[i][j] = Integer.MIN_VALUE;
//             }
//         }

//         // Start recursion from index 0 and total = 0
//         return backtrack(0, 0, nums, target);
//     }

//     private int backtrack(int i, int total, int[] nums, int target) {
//         // Base case: if end of array reached
//         if (i == nums.length) {
//             return total == target ? 1 : 0;
//         }

//         // Memoization check (shift index to handle negatives)
//         if (dp[i][total + totalSum] != Integer.MIN_VALUE) {
//             return dp[i][total + totalSum];
//         }

//         // Explore both +nums[i] and -nums[i]
//         dp[i][total + totalSum] =
//             backtrack(i + 1, total + nums[i], nums, target) +
//             backtrack(i + 1, total - nums[i], nums, target);

//         return dp[i][total + totalSum];
//     }
// }

