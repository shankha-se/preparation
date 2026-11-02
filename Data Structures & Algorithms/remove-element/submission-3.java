class Solution {

    public int removeElement(int[] nums, int val) {
        return removeElementSol1(nums, val);
        //return removeElementSol2(nums, val);
    }

    public int removeElementSol1(int[] nums, int val) {
        int j = 0; 
        
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        
        return j; // 'j' represents the new length of the valid array
    }

    public int removeElementSol2(int[] nums, int val) {
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