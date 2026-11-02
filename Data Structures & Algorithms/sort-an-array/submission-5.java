class Solution {
    public int[] sortArray(int[] nums) {
        return selectionSort(nums);
    }

    public int[] selectionSort(int[] nums) {
        for(int i = 0 ; i <= nums.length - 2; i++){
            int mi = i;
            for(int j = i+1 ; j <= nums.length - 1; j++){
                if (nums[j] <  nums[mi]) {
                    mi = j;
                }
            }
            swap(nums, i, mi);
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}