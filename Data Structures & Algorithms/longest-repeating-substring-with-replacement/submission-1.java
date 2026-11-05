class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, maxWindow = 0;

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char incoming = s.charAt(i);
            freq[incoming - 'A']++;
            maxFreq = Math.max(maxFreq, freq[incoming - 'A']);
            
            int windowLength = i - j + 1;
            if(windowLength - maxFreq > k){
                char outgoing = s.charAt(j);
                freq[outgoing - 'A']--;
                j++;
                windowLength = i - j + 1;
            }
            maxWindow = Math.max(maxWindow, windowLength);
        }
        return maxWindow;
    }
}
