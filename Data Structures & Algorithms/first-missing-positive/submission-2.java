class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Replace numbers out of range [1, n] with n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 2. Mark presence by making the value at index (val - 1) negative
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                int idx = val - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                }
            }
        }

        // 3. Find the first index with a positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}