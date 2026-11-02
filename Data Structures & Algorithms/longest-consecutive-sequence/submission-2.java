class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> calcSet = new HashSet<Integer>();
        for(int num : nums){
            calcSet.add(num);
        }
        
        int longestSequenceLength = 0;
        for(int num : calcSet){
            if ( !calcSet.contains(num-1)) {
                int seqLength = 1;
                int nextChecker = num;
                while (calcSet.contains(nextChecker + 1)) {
                    seqLength ++;
                    nextChecker ++;
                }
                longestSequenceLength = Math.max(longestSequenceLength, seqLength);
            } 
        }
        return longestSequenceLength;
    }
}
