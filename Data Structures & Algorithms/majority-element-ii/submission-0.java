class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int target = nums.length / 3; 
        for (int num : nums){
            map.put(num, map.getOrDefault( num , 0 ) + 1);
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int key : map.keySet()){
            if(map.get(key) > target){
                result.add(key);
            }
        }

        return result;
    }
}