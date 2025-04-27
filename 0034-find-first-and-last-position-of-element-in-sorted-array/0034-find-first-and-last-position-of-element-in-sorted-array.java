class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r =nums.length-1;
        int m=0;
        if(nums.length==0){
            return new int[] {-1,-1};
        }
        while(l<=r){
        m = l + (r - l) / 2;
        if(nums[m]<target){
            l = m+1;
            //m = (r+l)/2;
        }else if(nums[m]>target){
            r= m-1;
            //m = (r-l)/2;
        }else{
            break;
        }
        
        }
        // l=m;
        // r= m;
        System.out.println(m);
        //System.out.println(l);
        if(nums[m]!=target){
            return new int[] {-1,-1};
        }else{
            while((l<=m && nums[l]<target) || (r>=m && nums[r]>target)){
                if(l<=m && nums[l]<target){
                    l++;
                }
                if(r>=m && nums[r]>target){
                    r--;
                }
            }
        }
        //     while((l>0 && nums[l-1]==target) || (r< nums.length-1 && nums[r+1]==target)){
        //         if(l>0 && nums[l-1]==target ){
        //             l--;
        //         }
        //         if(r<nums.length-1 && nums[r+1]==target){
        //             r++;
        //         }
        //     } 
        // }else{
            
        // }
        return new int[] {l,r};
    }
}