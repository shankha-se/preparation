class Solution {
    public int[] sortArray(int[] nums) {
        return insertionSort(nums);
    }

    public int[] insertionSort(int[] nums) {
        for(int i = 1 ; i <= nums.length - 1; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
                if(nums[j + 1] < nums [j]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                else {
                    break;
                }
            }
        }
        return nums;
    }
}