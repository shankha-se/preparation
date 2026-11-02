class Solution {

    public int removeElement(int[] nums, int val) {
        return removeElementSol1(nums, val);
        //return removeElementSol2(nums, val);
    }

    public int removeElementSol1(int[] nums, int val) {
        int i = 0; 
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val){

            }
            else {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i; // 'i' represents the new length of the array
    }

    public int removeElementSol2(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int swapCounter = 0;
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
            swapCounter ++;

            i++;
            j--;
        }
        return i;
    }
}