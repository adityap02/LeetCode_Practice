class Solution {
    int[] arr;
    public int rob(int[] nums) {
        arr= new int[nums.length+1];
        Arrays.fill(arr, -1);
        return helper(nums, nums.length-1);
        
    }

    int helper(int[] nums, int i){
        if(i<0){
            return 0;
        }
        if(arr[i]!=-1){
            return arr[i];
        }
        int save = Math.max(helper(nums,i-2)+nums[i], helper(nums,i-1));
        arr[i] = save;
        return save;
    }
}