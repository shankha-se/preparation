class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Base case handling
        if(nums == null || nums.length == 0 || k == 0) {
            return new int[k];
        }

        // Frequency map creation
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Frequency(index) bucket creation an d fill it up
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()){
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
                bucket[freq].add(num);
            }
            else {
                bucket[freq].add(num);
            }
        }

        // Filling up the result array in a decreasing order
        int[] result = new int[k];
        int counter = 0;
        for (int i = bucket.length - 1; i >=0; i--){
            if(bucket[i] != null) {
                for (int ele : bucket[i]){
                    result[counter] = ele;
                    counter ++;
                    if(k == counter) {
                        return result;
                    }
                }
            }
        }
        return result;
        
    }
}
