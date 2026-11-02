class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> checkStartingMap = new HashMap<Integer, Boolean>();
        for(int num : nums) {
            checkStartingMap.put(num, true);
        }
        for(int num : checkStartingMap.keySet()){
            if(checkStartingMap.get(num) == false) {
                continue;
            }
            if(checkStartingMap.containsKey(num - 1)){
                checkStartingMap.put(num, false);
            }
        }
        int longestSequenceLength = 0;
        for(int num : checkStartingMap.keySet()){
            int seqLength = 0;
            if(checkStartingMap.get(num) == true) {
                seqLength ++;
                int nextChecker = num;
                while (checkStartingMap.containsKey(nextChecker + 1)) {
                    seqLength ++;
                    nextChecker ++;
                }
            }
            longestSequenceLength = Math.max(longestSequenceLength, seqLength);
        }
        return longestSequenceLength;
    }
}
