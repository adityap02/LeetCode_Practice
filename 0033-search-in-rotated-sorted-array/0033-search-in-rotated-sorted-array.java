class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;

            if(nums[m]==target){
                return m;
            }else if(nums[l]<=nums[m]){//changeover point is on right
                if(nums[l]<=target && target<nums[m]){//target is btwn (l & m)
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{
                //Changeover poitn is on left
                if(nums[m]<target && target <=nums[r]){//target btwn( m&r)
                    l = m+1;
                }else{
                    r = m-1;
                }
            }




        }
        return -1;
    }
}