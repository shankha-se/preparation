class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int j = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char acq = s.charAt(i);
            freq[acq] = freq[acq] + 1;

            while(freq[acq] > 1) {
                char rel = s.charAt(j);
                freq[rel] = freq[rel] - 1;
                j++;
            }
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}
