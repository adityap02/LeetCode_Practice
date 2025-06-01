class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] p1 = new int[nums.length];
        int[] p2 = new int[nums.length];
        p1[0]=1;
        for(int i=0;i<nums.length-1;i++){
            p1[i+1] = nums[i] * p1[i];
        }
        p2[nums.length-1] = 1;
        for(int i=nums.length-1;i>0;i--){
            p2[i-1] = nums[i] * p2[i];
        }
       for(int i=0;i<nums.length;i++){
           ans[i] = p1[i] * p2[i];
        }
        return ans;
        
    }
}
