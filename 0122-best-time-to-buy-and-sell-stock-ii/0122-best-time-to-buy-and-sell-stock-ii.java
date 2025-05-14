class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int prev = prices[0];
        for(int p : prices){
            if(p>prev){
                ans+=p-prev;
            }
            prev = p;
        }
        return ans;
    }
}