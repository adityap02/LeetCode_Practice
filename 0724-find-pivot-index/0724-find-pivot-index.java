class Solution {
        public int pivotIndex(int[] nums) {
            int ls= 0, rs=0, l =0, r = nums.length-1;
            for(int i=1;i<=r;i++){
                rs = rs+nums[i];
            }
            while(l<r && ls != rs){
                ls = ls+ nums[l]; 
                l++;
                rs = rs - nums[l];
                
            }
            if(ls ==rs){
                return l;
            }

            return -1;
        }
    }