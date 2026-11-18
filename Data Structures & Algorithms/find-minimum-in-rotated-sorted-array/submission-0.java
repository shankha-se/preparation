class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums[lo] <= nums[hi]) {
            return nums[0];
        }
        while( lo <= hi ) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            else if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            else if (nums[lo] <= nums[mid]) { // left part sorted
                lo = mid + 1;
            }
            else if (nums[mid] <= nums[hi]) { // right part sorted
                hi = mid - 1;
            }
        }
        return -1;
    }
}

