class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = 0;
        int sum = 0;
        int currWindowSize = 0, minLenWindow = Integer.MAX_VALUE, minSubArrLen = 0;

        int j = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target && j <= i){
                currWindowSize = i - j + 1;
                minLenWindow = Math.min(currWindowSize, minLenWindow);
                sum -= nums[j];
                j++;
            }
        }
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}