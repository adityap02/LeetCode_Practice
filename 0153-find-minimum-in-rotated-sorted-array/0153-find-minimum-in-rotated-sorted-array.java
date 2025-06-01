class Solution {
    public int findMin(int[] nums) {

        //Goal is to find the changeover point/start of the array, where the arr is rotated
        int l = 0, r = nums.length - 1, min = 5001;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[r] > nums[0]) {
            return nums[0];
            // if the last element is greater than the first element then there is no rotation.
        }
        while (r >= l) {
            int m = (l + r) / 2;
            //min = Math.min(min, nums[m]);

            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }//this means that the m+1 is the changeover point

            if (nums[m- 1] > nums[m]) {
                return nums[m];
            }//this means that the m is the changeover point


            //Otherwise go for binary search as usual
            if (nums[m] > nums[0]) {
                l = m + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value
                // is somewhere to
                // the left
                r = m - 1;
            }
        }
        return min;

    }
}