class Solution {
    public int[] twoSum(int[] nums, int target) {
       // Arrays.sort(nums);
         
        for(int i=0;i<nums.length;i++){
            int t = target-nums[i];
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]==t){
                    // result [] = new int[2];
                    // result.
                    return new int[] {i,j};
                }
        }

    }
            return null;
    }
}