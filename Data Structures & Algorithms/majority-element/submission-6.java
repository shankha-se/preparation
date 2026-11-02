class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        for(int i = 0 ; i <= nums.length - 1; i++){
            if (count == 0){
                count++;
                candidate = nums[i];
            }
            else if (candidate != nums [i]) {
                count --;
            }
            else if (candidate == nums [i]) {
                count ++;
            }
        }
        return candidate;    
    }
}