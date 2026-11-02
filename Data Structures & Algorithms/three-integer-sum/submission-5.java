class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int target = 0;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            if (nums[i] > 0) break;
            
            if(i > 0 && nums[i] == nums[i-1]) continue;

            long twoLoopTarget = (long)target - nums[i];

            int lo = i + 1;
            int hi = nums.length - 1;

            while(lo < hi){
                if(nums[lo] + nums[hi] == twoLoopTarget){
                    List<Integer> newResult = new ArrayList<>();
                    newResult.add(nums[i]);
                    newResult.add(nums[lo]);
                    newResult.add(nums[hi]);
                    result.add(newResult);

                    while(lo < hi && nums[lo] == nums[lo + 1]){
                        lo ++;
                    }
                    while(lo < hi && nums[hi] == nums[hi - 1]){
                        hi --;
                    }

                    lo ++;
                    hi --;
                }
                else if(nums[lo] + nums[hi] > twoLoopTarget){
                    hi --;
                }
                else if(nums[lo] + nums[hi] < twoLoopTarget){
                    lo ++;
                }
            }
        }
        return result;
    }
}
