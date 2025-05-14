class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int ans=0;
        for(int s : set){
                if(!set.contains(s-1)){ //this means , for any particular sequence - this is the smallest number of that sequence
                    int currLen = 1, startNum=s;

                    while(set.contains(startNum+1)){
                        startNum+=1;
                        currLen+=1;
                    }
                    ans = Math.max(ans, currLen);
                }
        }

        return ans;
    }
}