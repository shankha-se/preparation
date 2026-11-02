class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for(int k = 0; k <= nums.length - 4; k++){
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            for(int i = k + 1; i <= nums.length - 3; i++){
                if(i > k + 1 && nums[i] == nums[i-1]) continue;

                long twoLoopTarget = (long)target - nums[i] - nums[k];

                int lo = i + 1;
                int hi = nums.length - 1;

                while(lo < hi){
                    if(nums[lo] + nums[hi] == twoLoopTarget){
                        List<Integer> newResult = new ArrayList<>();
                        newResult.add(nums[k]);
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
        }
        return result;
    }

}
