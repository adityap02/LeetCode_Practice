class Solution {
    //O(n * 2^n) -> n is length of candidates array
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Backtracking by skipping duplicate numbers
        List<List<Integer>> ans = new ArrayList<>();
        //Sort the candidates array to handle duplicates and facilitate the backtracking process.
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        //nums,target,index,curr,answer,sum
        backtrack(candidates,target,0,curr,ans,0);
        return ans;

    }

    void backtrack(int[] nums,int target,int index, List<Integer> curr, List<List<Integer>> ans, int sum){
        if(sum==target){
            ans.add(new ArrayList(curr));
            return;
        }

        if(sum>target || index == nums.length){
            return;
        }

        curr.add(nums[index]);
        backtrack(nums,target,index+1, curr, ans, sum+nums[index]);
        curr.remove(curr.size()-1);
        //Skipping all duplicate elements
        while(index+1< nums.length && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(nums,target,index+1, curr, ans, sum);
    }
}