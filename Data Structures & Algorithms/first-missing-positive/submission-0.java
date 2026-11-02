class Solution {
    public int firstMissingPositive(int[] nums) {

        if( nums ==  null || nums.length == 0){
            return 0;
        }

        // Clean up the array 
        for(int i = 0; i<= nums.length - 1; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }

        // Mark the Array
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val <= nums.length) {
                int idx = val - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx]; // Flip to negative to mark visited
                }
            }
        }

        // Find the answer
        for(int i = 0; i<= nums.length - 1; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}