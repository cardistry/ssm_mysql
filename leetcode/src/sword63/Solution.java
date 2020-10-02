package sword63;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int purchase = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length;++i){
            if(prices[i] - purchase > profit)
                profit = prices[i] - purchase;
            if(prices[i] < purchase)
                purchase = prices[i];

        }
        return profit;

    }
}