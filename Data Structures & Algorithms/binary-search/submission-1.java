class Solution {
    public int search(int[] nums, int target) {
       return b_search(nums, target, 0, nums.length - 1);
    }

    public int b_search(int[] nums, int target, int lo, int hi){
        if (lo > hi){
            return -1;
        }
        int mid = (lo + hi) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        else if(nums[mid] > target){
            return b_search(nums, target, lo, mid - 1);
        }
        else {
            return b_search(nums, target, mid + 1, hi);
        }
    }
}
