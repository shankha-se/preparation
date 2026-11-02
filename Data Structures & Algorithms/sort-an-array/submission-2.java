class Solution {
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }

    public int[] quickSort(int[] nums) {
        if (nums == null) {
            return null;
        }
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qSort(int[] nums, int lo, int hi) {
        if (lo >= hi){
            return;
        }
        int pivot = nums[hi];
        int pi = partition(nums, pivot, lo, hi);
        qSort(nums, lo, pi - 1);
        qSort(nums, pi + 1, hi);
    }

    private static int partition(int[] nums, int pivot, int lo, int hi) {
        int i = lo;
        int j = lo;
        // i - end ==> Unknown zone
        // 0 - i-1 ==> Less than pivot
        // j - i-1 ==> More than pivot
        while(i <= hi) {
            if (nums[i] > pivot) {
                i ++;
            }
            else {
                swap(nums, i, j);
                i ++;
                j ++;
            }
        }
        return j - 1; 
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}