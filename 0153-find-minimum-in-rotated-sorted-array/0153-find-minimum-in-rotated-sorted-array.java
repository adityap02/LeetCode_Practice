class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[r] > nums[0]) {
            return nums[0];
            // if the last element is greater than the first element then there is no rotation.
        }
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } //this means that the m+1 is the changeover point
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } //this means that the m is the changeover point

            if (nums[mid] > nums[l]) {
                l=mid+1;
            }else{
                r = mid-1;
            }
        }
        return min;
    }
}