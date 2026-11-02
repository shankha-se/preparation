class Solution {
    public int[] sortArray(int[] nums) {
        return exchangeSort(nums);
    }

    public int[] exchangeSort(int[] nums) {
        for(int i = 0 ; i <= nums.length - 2; i++){
            for(int j = i+1 ; j <= nums.length - 1; j++){
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}