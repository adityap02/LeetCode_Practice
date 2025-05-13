class Solution {
    public int maxSubArray(int[] nums) {
        int memo =nums[0];
        int result = memo;
        for(int i =1; i < nums.length;i++){
            memo = Math.max(nums[i], memo+nums[i]);
            result = Math.max(memo , result);
        }
        return result;
    }


}