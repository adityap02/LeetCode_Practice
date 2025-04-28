class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0,r =1, max = nums[0];
        if(nums.length==1){
            return 1;
        }
        for(int i =1;i<nums.length;i++){
            //System.out.println(l);
            //.out.println(i);
            if(nums[i]>nums[l]){
                nums[++l]=nums[i];
            }
            //System.out.println(Arrays.toString(nums));

        }

         return l+1;
    }
}