class Solution {
    public void reverseString(char[] s) {
        String reversed = reverse(new String(s));
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed.charAt(i);
        }
    }

    public String reverse(String s) {
        int stringLength = s.length();
        if (stringLength <= 1) {
            return s;
        }
        char lastChar = s.charAt(stringLength - 1);
        String reversedString = lastChar + reverse(s.substring(0, stringLength - 1));
        return reversedString;
    }
}