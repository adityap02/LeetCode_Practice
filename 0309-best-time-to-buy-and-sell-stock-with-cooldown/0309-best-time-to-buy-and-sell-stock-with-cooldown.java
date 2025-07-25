class Solution {
    public int maxProfit(int[] prices) {
//any of these three states - -buy, sell and rest.


//(1) We have to `rest` before we `buy` and 
//(2) we have to `buy` before we `sell`


//Track the best profit on each day by deciding whether to buy or sell using previously computed states.
//Use variables buy and sell to simulate state transitions with cooldown, updating based on the best previous choices.
    int sell = 0, buy = Integer.MIN_VALUE, prev_sell = 0,  prev_buy=0;
    for (int price : prices) {
        prev_buy = buy;// Store the previous day's buy value before updating
        buy = Math.max(prev_sell - price, prev_buy);// Decide to buy today (after cooldown) or keep previous buy
        prev_sell = sell;// Store the previous day's sell value before updating
        sell = Math.max(prev_buy + price, prev_sell);// Decide to sell today (using previous buy) or keep previous sell
    }
    //O(n)
    return sell;
}
}
