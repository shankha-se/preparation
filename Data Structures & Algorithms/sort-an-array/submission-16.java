class Solution {
    public int[] sortArray(int[] nums) {
        return countSort(nums);
    }

    public int[] countSort(int[] nums) {
        //min, max and range. And create empty Freq Arr 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int range;
        for (int num : nums){
            max = Math.max(num, max);
            min = Math.min(num, min); 
        }
        range = max - min + 1;
        int[] fNums = new int[range];

        // Fill up the freq Arr and Create prefix Sum array in it
        for (int i = 0; i <= nums.length - 1; i++){
            int val = nums[i];
            int index = val - min;
            fNums[index] = fNums[index] + 1;
        }

        for (int i = 1; i <= fNums.length - 1; i++){
            fNums[i] = fNums[i - 1] + fNums[i];
        }

        // Create a new array and fill it up
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            int val = nums[i];
            int pos = fNums[val - min] - 1;
            ans[pos] = val;
            fNums[val - min]--;
        }

        return ans;
    }
}