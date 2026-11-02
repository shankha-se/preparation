class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int[] prodNums = new int[nums.length];

        prodNums[0] = 1;
        for(int i = 1; i <= nums.length -1 ; i++){
            prodNums[i] = nums[i - 1] * prodNums[i - 1];
        }

        int postProd = 1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            prodNums[i] = prodNums[i] * postProd;
            postProd = postProd * nums[i];
        }

        return prodNums;
        
    }
}  
