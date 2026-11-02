class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (Integer mapKey : map.keySet()){
            if (map.get(mapKey) > nums.length / 2){
                return mapKey;
            }
        }
        return -1;
    }
}