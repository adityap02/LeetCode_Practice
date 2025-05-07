class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length==1){
            return 0;
        }
        if(prices.length==2){
            return prices[1]-prices[0] - fee;
        }
        int buy = prices[0], profit =0;
        for(int i =1; i<prices.length;i++){
            int t = profit;
            profit = Math.max(profit,prices[i]-fee-buy);
            buy = Math.min(buy,prices[i]-profit);
        }
        return profit;

    }
}