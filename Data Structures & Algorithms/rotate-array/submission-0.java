class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k = nums.length + k;
        }

        //part 1
        reverse(nums, 0, nums.length - 1 - k);
        //part 2
        reverse(nums, nums.length - k, nums.length - 1);
        //part 3
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}