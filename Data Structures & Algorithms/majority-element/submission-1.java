class Solution {
    public int majorityElement(int[] nums) {
        //return majorityElementSol1(nums);
        return majorityElementSol2(nums);
    }

    public int majorityElementSol1(int[] nums) {
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

    public int majorityElementSol2(int[] nums) {
        int count = 0;
        int candidate = -1;
        for(int i = 0 ; i <= nums.length - 1; i++){
            if (count == 0){
                count++;
                candidate = nums[i];
            }
            else {
                if (candidate != nums [i]) {
                    count --;
                }
                else {
                    count ++;
                }
            }
        }
        return candidate;    
    }
}