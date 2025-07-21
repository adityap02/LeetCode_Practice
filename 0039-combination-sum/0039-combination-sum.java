class Solution {
    //BackTacking Solution
    //O(2^(T/M))
    // Where t is target and m is minimum value in nums
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList();
        backtrack(candidates, target, 0, ans, curr);
        return ans;
    }

    void backtrack(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> curr) {
        //if condition met -> add to ans list
        if (target == 0) {
            ans.add(new ArrayList(curr));
            return;
        }
        //Base Conditions m if sum > target or index exceed length return 
        if (target < 0 || index >= candidates.length) {
            return;
        }

        curr.add(candidates[index]);
        //Use the element
        backtrack(candidates, target - candidates[index],index, ans ,curr);
        curr.remove(curr.size() - 1);
        //Not use the element
        backtrack(candidates, target, ++index, ans,curr);
    }

}