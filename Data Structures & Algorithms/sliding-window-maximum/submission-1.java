class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            //Is the last value in the deque smaller than the new incoming value? If YES, remove it.
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            //Has the index at the front of the deque fallen behind the left boundary of our window? If YES, remove it.
            if (l > q.getFirst()){
                q.removeFirst();
            }

            //Have we processed enough elements to form our first complete window?
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
