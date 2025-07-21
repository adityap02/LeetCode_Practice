class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //O(n! * n) & SC : O(n! *n)
        List<List<Integer>> ans = new ArrayList<>();
        //Will Maintain arraylist curr to make the permutations, and Boolean Array 
        //to one by one select each element, pick it backtrack it while keeping others false in it
        //Basically we are creating permutations by trying to keep all elements at each positions one by one
        backtrack(nums, new ArrayList<>(), ans,new boolean[nums.length]);
        return ans;
    }

    void backtrack(int[] nums, List<Integer> cur, List<List<Integer>> ans, boolean[] pick) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //this will run for each element in array, keeping each element 1st place in permutation
            //and similarly backtrack will  provide place for all other elements on other positions 
            if (!pick[i]) {
                cur.add(nums[i]);
                pick[i] = true;
                backtrack( nums, cur, ans, pick);
                cur.remove(cur.size() - 1);
                pick[i] = false;
            }
        }
    }
}