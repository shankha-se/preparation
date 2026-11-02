class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcp = "";
        if (strs == null || strs.length == 0) {
            return lcp;
        }
        for (int i = 0 ; i <= strs[0].length() - 1 ; i++){
            Character firstStringChar = strs[0].charAt(i);
            for (int n = 1 ; n <= strs.length - 1 ; n++){
                if (i >= strs[n].length()){
                    return lcp;
                }
                Character otherStringChar = strs[n].charAt(i);
                if (firstStringChar != otherStringChar) {
                    return lcp;
                }
            }
            lcp += firstStringChar;
        }
        return lcp;
    }
}