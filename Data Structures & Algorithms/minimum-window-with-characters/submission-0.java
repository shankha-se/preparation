class Solution {
    public String minWindow(String s, String t) {
        int[] mapT = new int[256];
        int[] mapS = new int[256];
        int minWindowLen = Integer.MAX_VALUE;
        String minWindow = "";

        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char incoming = s.charAt(i);
            mapS[incoming]++;
            while (isComplete(mapS, mapT)){
                int currLen = i - j + 1;
                if(currLen < minWindowLen){
                    minWindowLen = currLen;
                    minWindow = s.substring(j,i+1);
                }
                char outgoing = s.charAt(j);
                mapS[outgoing]--;
                j++;
            }
        }
        return minWindow;
    }

    private boolean isComplete(int[] mapS, int[] mapT){
        for (int i = 0; i < 256; i++) {
            if(mapS[i] < mapT[i]){
                return false;
            }
        }
        return true;
    }
}
