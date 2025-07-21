class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Time complexity: O(n *2^n)
        //Space complexity:O(n)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, res);
        return res;

    }

    void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> res){
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        //Recurse Once by using the current element
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset, res);
        //Recurse Once without using the current element
        subset.remove(subset.size() - 1);
        backtrack(nums, index + 1, subset, res);

    }
}