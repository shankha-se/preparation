class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }

        HashMap<Character, Integer> freqS1 = new HashMap();
        for (Character ch : s1.toCharArray()){
            freqS1.put(ch, freqS1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> freqS2 = new HashMap();
        for (int i = 0; i < len1; i++){
            char ch = s2.charAt(i);
            freqS2.put(ch, freqS2.getOrDefault(ch, 0) + 1);
        }

        if (freqS1.equals(freqS2)){
            return true;
        }

        int j = 0;
        for (int k = len1; k < len2; k++){
            char incoming = s2.charAt(k);
            char outgoing = s2.charAt(j);
            freqS2.put(incoming, freqS2.getOrDefault(incoming, 0) + 1);
            if (freqS2.get(outgoing) == 1) {
                freqS2.remove(outgoing);
            } else {
                freqS2.put(outgoing, freqS2.get(outgoing) - 1);
            }
            if (freqS1.equals(freqS2)){
                return true;
            }
            j++;
        }
        return false;
    }
}
