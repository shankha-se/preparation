class Solution {
    public int maxProfit(int[] prices) {
        return buyAndSell2(prices);
    }

    /*
    //Only one transaction allowed
    public int buyAndSell1(int[] prices) {
        int leastPriceTillToday = Integer.MAX_VALUE;
        int priceIfSoldToday = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i <= prices.length - 1; i++){
            int priceToday = prices[i];
            leastPriceTillToday = Math.min(leastPriceTillToday, priceToday);
            priceIfSoldToday = priceToday - leastPriceTillToday;
            maxProfit = Math.max(maxProfit, priceIfSoldToday);
        }
        return maxProfit;
    }*/

    //Any number of transaction allowed
    public int buyAndSell2(int[] prices) {
        int maxProfit = 0;
        int buyDate = 0;
        int sellDate = 0;
        for(int i = 1; i <= prices.length - 1; i++){
            int priceYesterDay = prices[i-1];
            int priceToday = prices[i];
            if(priceToday >= priceYesterDay){
                sellDate ++;
            }
            else {
                maxProfit += (prices[sellDate] - prices[buyDate]);
                buyDate = i;
                sellDate = i;
            }
        }
        maxProfit += (prices[sellDate] - prices[buyDate]);
        return maxProfit;
    }
}