class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         //Time complexity: O(n *2^n)
        //Space complexity:O(n)
        List<List<Integer>> ans = new ArrayList<>();
        //Sort the candidates array to handle duplicates and facilitate the backtracking process.
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), ans,0);
        return ans;
    }

    void backtrack(int[] nums,List<Integer> cur, List<List<Integer>> ans, int index){
        //base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        //Recurse Once by using the current element
        cur.add(nums[index]);
        backtrack(nums, cur, ans,index + 1);
        //Skipping all Duplicate Elements
        while(index+1< nums.length && nums[index+1]==nums[index]){
            index++;
        }
        //Recurse Once without using the current element
        cur.remove(cur.size() - 1);
        backtrack(nums, cur, ans,index + 1);


    }
}