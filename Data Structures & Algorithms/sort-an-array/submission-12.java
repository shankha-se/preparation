class Solution {
    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    public int[] heapSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ();
        for(int num : nums){
            pq.add(num);
        }
        int i = 0;
        while(pq.size() > 0){
            nums[i] = pq.remove();
            i++;
        }
        return nums;
    }
}