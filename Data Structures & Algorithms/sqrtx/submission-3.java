class Solution {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x/2 + 1;
        while(lo <= hi){
            long mid = lo + (hi-lo ) / 2;
            long square = mid * mid;
            if(square > x){
                hi = (int)mid - 1;
            }
            else if(square < x){
                lo = (int)mid + 1;
            }
            else {
                return (int)mid;
            }
        }
        return (int)hi;
    }
}