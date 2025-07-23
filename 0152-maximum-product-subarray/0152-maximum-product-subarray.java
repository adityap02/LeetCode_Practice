class Solution {
    public int maxProduct(int[] nums) {
            // DP 
            //2 values, Negative So Far and Positive So Far
            // Keepking Negative so far because we can anytime get another negative value and multiplying
            //that will make it bigger positive number 

        int posMax = nums[0];
        int negMax = nums[0];
        int max = posMax;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //getting max
            int temp = Math.max(curr, Math.max(posMax*curr,negMax*curr));
            //getting min ( if there is a negative val) 
            negMax = Math.min(curr,Math.min(posMax*curr,negMax*curr));
            posMax = temp;
            
            max = Math.max(posMax,max);
        }
        return max;
    }//TC : O(n) , SC O(1)
}