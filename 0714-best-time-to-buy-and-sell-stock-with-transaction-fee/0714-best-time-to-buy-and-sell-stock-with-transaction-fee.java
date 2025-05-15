class Solution {
    public int maxProfit(int[] prices, int fee) {
        // if(prices.length==1){
        //     return 0;
        // }
        // if(prices.length==2){
        //     return prices[1]-prices[0] - fee;
        // }
        // int buy = prices[0], profit =0;
        // for(int i =1; i<prices.length;i++){
        //     profit = Math.max(profit,prices[i]-fee-buy);
        //     buy = Math.min(buy,prices[i]-profit);
        // }
        // return profit;



        //[1,3,2,8,4,9] fee = 2
        //Max(sell or hold)
        // Hold : abhi tak ka kharcha, hold rakhne me -> Max(hold, free-prices[i]) -> ya to hold karte raho pehle wale price pe , ya fir pichla best sell ( free) - pries[i] (abhi ka khareed)
        //Free - abhi tak ka max profit - best bechne ke bad ... -> Max(free , hold(prev) + prices[i] - fee) -> ya to becha hua hi rehne do ya yaha pe bech do ( hold(prev) -> abhi tak ka best hold profit(khareed included h) + abhi ka ye price jispe sell kar rahe - Fee) 
        int free = 0, hold = -prices[0]; 

        for(int i : prices){
            int t = hold;
            hold = Math.max(hold, free- i);
            free = Math.max(free, t+i-fee);
        }
        return free;

    }
}