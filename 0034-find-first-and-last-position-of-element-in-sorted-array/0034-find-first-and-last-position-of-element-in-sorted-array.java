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

    //Easy Approach - Binary Search + L-R Pointers
    // class Solution {
    // public int[] searchRange(int[] nums, int target) {
    //     if(nums.length==1 && nums[0]==target){
    //         return new int[] {0,0};
    //     }
    //     int pos = binarySearch(nums, target, 0, nums.length-1);
    //     if(pos==-1){
    //         return new int[] {-1,-1};
    //     }else{
    //         int l =pos,r=pos;
    //         while(true){
    //             if(l>=0 && nums[l]==target){
    //                 l--;
    //             } else if(r<=nums.length-1 && nums[r]==target){
    //                 r++;
    //             }else{
    //                 break;
    //             }
    //         }
    //         return new int[] {l+1,r-1};
    //     }
        
    // }


    //     int binarySearch(int array[], int target, int low, int high) {
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (target == array[mid])
    //             return mid;
    //         if (target < array[mid])
    //             high = mid - 1;
    //         else
    //             low = mid + 1;
    //     }
    //     return -1;
    // }

}