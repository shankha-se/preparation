class Solution {
    public int subarraySum(int[] nums, int k) { 
        int ans = 0;
        
        HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        sumMap.put(0,1);
        int sum = 0;
        for(int i = 0; i <= nums.length - 1; i++) {
            sum += nums[i];
            int valueToLookFor = sum - k;

            if (sumMap.containsKey(valueToLookFor)) {
                ans += sumMap.get(valueToLookFor);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}