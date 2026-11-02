class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int[] preProd = new int[nums.length];
        int[] postProd = new int[nums.length];
        int[] prodNums = new int[nums.length];

        preProd[0] = 1;
        for(int i = 1; i <= nums.length -1 ; i++){
            preProd[i] = nums[i - 1] * preProd[i - 1];
        }

        postProd[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0 ; i--){
            postProd[i] = nums[i + 1] * postProd[i + 1];
        }

        for(int i = 0; i <= nums.length - 1 ; i++){
            prodNums[i] = preProd[i] * postProd[i];
        }

        return prodNums;

    }
}  
