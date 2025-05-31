class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); //key -> Sum , val -> num of ways to achieve that Sum
        map.put(0,1);//base case where no element is selected ( sum =0) , there is 1 way to achieve that 
        int ans =0, sum =0;
        for(int i =0; i < nums.length;i++){
            sum+= nums[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
        //Time complexity : O(n). The entire nums array is traversed only once.
        //Space complexity : O(n). Hashmap map can contain up to n distinct entries in the worst case.
    }
}