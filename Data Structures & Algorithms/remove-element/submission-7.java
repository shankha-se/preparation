class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            while(i <=  j && nums[i] != val){
                i++;
            }
            while(i <=  j && nums[j] == val){
                j--;
            }
            if (i >= j) {
                break;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
        return i;
    }
}