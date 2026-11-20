class Solution {
    public int splitArray(int[] nums, int k) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        int ans = 0;
        for(int num : nums){
            lo = Math.max(lo, num); // lo will be maximum value of the array
            hi += num; // hi will be the summation of all values
        }

        if(nums.length == k){
            return lo;
        }

        while(lo <= hi){
            int mid = lo + ( hi - lo ) / 2;
            if(isPossible(nums, k, mid)){
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int maxValue){
        int subArrCount = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum > maxValue){
                sum = nums[i];
                subArrCount++;
            }
        }
        return (k >= subArrCount);
    }
}