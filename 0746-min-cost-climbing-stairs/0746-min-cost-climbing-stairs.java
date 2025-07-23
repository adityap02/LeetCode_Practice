class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //start from the end of the array... See what's the cost to reach end from that stair ? it's cost[last] , 
        //because from last step, it will directly reach end utilizing the last stair...
        // Similarly do for all, in this process, we only need to keep the next two costs in memory to calculate the 
        // cost of last third... So it will go like for cost = [1,100,1,1,1,100,1,1,100,1] and (going from last to first in costs) 
        //dp[6,105,5,5,4,102,3,2,100,1]
        int[] dp = new int[2];
        //this is reverse dp array and of size 2 because ift's cost optimized, we only need to have at most last 2 costs in memory 
        dp[0] = cost[cost.length-2];
        dp[1] = cost[cost.length-1];
        for(int i =cost.length-3; i>=0;i--){
            int t = cost[i];
            int temp = Math.min(dp[0],dp[1]);
                dp[1] = dp[0];
                dp[0] = temp+t;
        }
        //whichever is less , 0th index or 1st index -> will start from there
        return dp[0]<dp[1] ? dp[0] : dp[1];
}
}