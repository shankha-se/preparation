class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) {
            return new int[k];
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            pQueue.add(key);
            if(pQueue.size() > k) {
                pQueue.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(pQueue.size() > 0){
            result[i] = pQueue.poll();
            i++;
        }

        return result;
        
    }
}
