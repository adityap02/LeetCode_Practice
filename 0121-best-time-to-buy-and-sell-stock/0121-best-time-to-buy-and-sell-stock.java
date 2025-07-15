class Solution {
    public int maxProfit(int[] prices) {
        //NO DP Solution ( Submission Accepted -  but 3%)
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // for(int i =0; i< prices.length; i++){
        //     if(prices[i]<min){
        //         min = Math.min(min,prices[i]);
        //         for(int j=i+1; j< prices.length;j++){
        //             max = Math.max(max,prices[j]-prices[i]);
        //     }

        //     }

        // }
        // return max <=0 ? 0 : max;

        //Sliding Window Solution
        if(prices.length ==1){
            return 0;
        }
        int max = 0;
        int buy=0, sell=1;
        while(sell<prices.length){
            int diff = prices[sell]-prices[buy];
            if(diff<=0){
                buy=sell;
                sell++;
            }else{
                sell++;
                max = Math.max(max,diff);
            }
        }

        return max;


    }
}