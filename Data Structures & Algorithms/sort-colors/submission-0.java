class Solution {
    public void sortColors(int[] nums) {

        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        // i -> k : Unknown
        // 0 -> j-1 : 0's
        // j -> i-1 : 1's
        // k+1 -> end : 2's

        while(i <= k) {
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
                i++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                k--;
            }
        }

        
    }
}