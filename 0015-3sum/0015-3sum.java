class Solution {
    class Triplet {
        int i, j, k;

        Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        List<Integer> toList() {
            return Arrays.asList(i, j, k);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, ans);
            }
        }
        return ans;
    }

    void twoSum(int[] nums, int i, List<List<Integer>> ans) {
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int s = nums[i] + nums[l] + nums[r];
            if(s==0){
                ans.add(new Triplet(nums[i],nums[l],nums[r]).toList());
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }

            }else if(s<0){
                l++;
            }else{
                r--;
            }
        }
    }
}