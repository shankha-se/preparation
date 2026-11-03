class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for(int i = 0; i < len1; i++){
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        if (matches(countS1, countS2)) {
            return true;
        }

        int j = 0;
        for (int k = len1; k < len2; k++){
            char incoming = s2.charAt(k);
            char outgoing = s2.charAt(j);
            countS2[incoming - 'a']++;
            countS2[outgoing - 'a']--;

            if (matches(countS1, countS2)) {
                return true;
            }
            j++;
        }
        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
