class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int l=0, r =nums.length-1;
        // int m=0;
        // if(nums.length==0){
        //     return new int[] {-1,-1};
        // }
        // while(l<=r){
        // m = l + (r - l) / 2;
        // if(nums[m]<target){
        //     l = m+1;
        //     //m = (r+l)/2;
        // }else if(nums[m]>target){
        //     r= m-1;
        //     //m = (r-l)/2;
        // }else{
        //     break;
        // }
        
        // }
        // // l=m;
        // // r= m;
        // System.out.println(m);
        // //System.out.println(l);
        // if(nums[m]!=target){
        //     return new int[] {-1,-1};
        // }else{
        //     while((l<=m && nums[l]<target) || (r>=m && nums[r]>target)){
        //         if(l<=m && nums[l]<target){
        //             l++;
        //         }
        //         if(r>=m && nums[r]>target){
        //             r--;
        //         }
        //     }
        // }
        // return new int[] {l,r};
        //MUCH BETTER SOLUTION
         int first = findPosition(nums, target, true);
        int last = findPosition(nums, target, false);
        
        return new int[] { first, last };

    }
        private int findPosition(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                pos = mid;
                if (findFirst) 
                    right = mid - 1;
                else 
                    left = mid + 1;
            } 
            else if (nums[mid] < target) 
                left = mid + 1;
            else 
                right = mid - 1;
        }

        return pos;
    }
}