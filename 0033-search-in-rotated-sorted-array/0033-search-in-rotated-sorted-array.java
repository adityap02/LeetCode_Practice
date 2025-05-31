class Solution {
    public int search(int[] nums, int target) {
       //basic Bin search
       //if mid large than LeftMost -> means  Left half array is sorted , else Right Half is sorted
       
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            //subarray on mid's left is sorted
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {//subarray on mid's right is sorted
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;

    }
}