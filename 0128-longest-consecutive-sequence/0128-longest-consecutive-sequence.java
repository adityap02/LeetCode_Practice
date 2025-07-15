class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int n :nums){
            set.add(n);
        }

        for(int n: set){
            if(!set.contains(n-1)){
                int len =1 , start = n;
                while(set.contains(start+1)){
                    start++;
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }
        //for(int i =0;i<nums)
        return ans;
    }
}