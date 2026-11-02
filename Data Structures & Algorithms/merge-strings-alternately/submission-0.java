class Solution {
    public String mergeAlternately(String word1, String word2) {

        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();
        int i = 0;
        int j = 0;
        char[] wordArrRes = new char[wordArr1.length + wordArr2.length];
        int k = 0;

        while (i < wordArr1.length && j < wordArr2.length) {
            wordArrRes[k] = wordArr1[i];
            i++;
            k++;
            wordArrRes[k] = wordArr2[j];
            j++;
            k++;
        }

        while (i < wordArr1.length) {
            wordArrRes[k] = wordArr1[i];
            i++;
            k++;
        }

        while (j < wordArr2.length) {
            wordArrRes[k] = wordArr2[j];
            j++;
            k++;
        }

        return new String(wordArrRes);

        
    }
}