class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //Ierate from start to end. At each iteration, use a second for loop to iterate from 0 up until i 
        //(all the elements before i). For each element before i, check if that element is smaller than nums[i]. 
        //This means in our DP array we will store for each position, what is the longest Inc Subsequence till this pos
        //If so, set dp[i] = max(dp[i], dp[j] + 1).
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //Stores the best LIS at this position, either previous value of newly calculated value 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //At end we will 
        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }//Time complexity: O(N ^2)
}
//Binary Search Solution (O(nlogn))
// public class Solution {
//     public int lengthOfLIS(int[] nums) {
//         List<Integer> dp = new ArrayList<>();
//         dp.add(nums[0]);

//         int LIS = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (dp.get(dp.size() - 1) < nums[i]) { 
//                 dp.add(nums[i]);
//                 LIS++;
//                 continue;
//             }

//             int idx = Collections.binarySearch(dp, nums[i]);
//             if (idx < 0) idx = -idx - 1; 
//             dp.set(idx, nums[i]); 
//         }

//         return LIS;
//     }