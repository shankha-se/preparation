class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k = n + k;
        }

        //part 1
        reverse(nums, 0, n - 1 - k);
        //part 2
        reverse(nums, n - k, n - 1);
        //part 3
        reverse(nums, 0, n - 1);
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