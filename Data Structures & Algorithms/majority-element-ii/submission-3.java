class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return majority;
        }

        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for(int i = 0 ; i <= nums.length - 1; i++){
            if (count1 == 0){
                count1++;
                candidate1 = nums[i];
            }
            else if (count2 == 0 && candidate1 != nums[i]) {
                count2++;
                candidate2 = nums[i];
            }
            else if (candidate1 == nums[i]) {
                count1++;
            }
            else if (candidate2 == nums[i]) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;
        for(int i = 0 ; i <= nums.length - 1; i++){
            if (nums[i] == candidate1) {
                count1++;
            }
            else if (nums[i] == candidate2) {
                count2++;
            }
        }

        int threshhold = nums.length / 3;
        if (count1 > threshhold){
            majority.add(candidate1);
        }
        if (count2 > threshhold && candidate1 != candidate2){
            majority.add(candidate2);
        }

        return majority;    
    }
}