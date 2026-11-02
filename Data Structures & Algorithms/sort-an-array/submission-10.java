class Solution {
    public int[] sortArray(int[] nums) {
        // return exchangeSort(nums);
        return bubbleSort(nums);
        // return selectionSort(nums);
        // return insertionSort(nums);
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

    public int[] bubbleSort(int[] nums) {
        for(int i = 1 ; i <= nums.length - 1; i++){
            for(int j = 0 ; j <= nums.length - 1 - i; j++){
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public int[] selectionSort(int[] nums) {
        for(int i = 0 ; i <= nums.length - 2; i++){
            int mi = i;
            for(int j = i+1 ; j <= nums.length - 1; j++){
                if (nums[j] <  nums[mi]) {
                    mi = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[mi];
            nums[mi] = temp;
        }
        return nums;
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