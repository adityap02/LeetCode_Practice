class Solution {
    public int[] productExceptSelf(int[] nums) {
        //two pass (two arrays)
        // TC & SC Both : O(n)

        int[] one = new int[nums.length + 1];
        Arrays.fill(one, 1);
        int[] two = new int[nums.length + 1];
        Arrays.fill(two, 1);
        int[] ans = new int[nums.length];

        // Fill prefix array
        for (int i = 1; i < one.length; i++) {
            one[i] = one[i - 1] * nums[i-1];
        }

        // Fill Suffix array
        for (int i = nums.length - 1; i >= 0; i--) {
            two[i] = two[i + 1] * nums[i];
        }
        for (int i = 0; i<ans.length; i++) {
            ans[i] = two[i + 1] * one[i];
        }
        return ans;
    }
}