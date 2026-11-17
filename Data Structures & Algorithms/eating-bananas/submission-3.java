class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) {
            return -1;
        }
        int maxBananas = Integer.MIN_VALUE;
        for(int pile : piles){
            maxBananas = Math.max(maxBananas, pile);
        }
        if(h == piles.length){
            return maxBananas;
        }

        int lo = 1;
        int hi = maxBananas;
        int ans = maxBananas;

        while(lo <= hi){
            int midSpeed = lo + (hi - lo)/2;
            if(isPossible(piles, h, midSpeed)){
                ans = midSpeed;
                hi = midSpeed - 1;
            }
            else {
                lo = midSpeed + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] piles, int h, int speed){
        long totalTimeTaken = 0;
        for(int pile : piles){
            totalTimeTaken += (long)Math.ceil(pile * 1.0/speed);
        }
        return (h >= totalTimeTaken);
    }
}
