class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = Integer.MIN_VALUE;
        for(int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }
        if(days == weights.length){
            return maxWeight;
        }
        
        int lo = maxWeight;
        int hi = totalWeight;
        int ans = lo;

        while(lo <= hi){
            int midWeightCapacity = lo + (hi - lo) / 2;
            if(isPossible(weights, days, midWeightCapacity)){
                ans = midWeightCapacity;
                hi = midWeightCapacity - 1;
            }
            else {
                lo = midWeightCapacity + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] weights, int days, int capacity) {
        int currentload = 0;
        days --;

        for(int weight : weights){
            if(currentload + weight > capacity){
                days--;
                currentload = weight;
            }
            else {
                currentload += weight;
            }
            if (days < 0) {
                return false;
            }
        }
        return true;
    }
}