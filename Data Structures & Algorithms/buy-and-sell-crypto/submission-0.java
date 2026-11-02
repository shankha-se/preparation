class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        int priceIfSoldToday = 0;
        int maxProfit = 0;

        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            priceIfSoldToday = price - minPrice;
            maxProfit = Math.max(maxProfit, priceIfSoldToday);
        }
        return maxProfit;
    }
}
