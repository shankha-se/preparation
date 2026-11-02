class Solution {
    public void reverseString(char[] s) {
        Stack<Character> temp = new Stack<>();

        for(char c : s) {
            temp.push(c);
        }

        int i = 0;
        while(!temp.isEmpty()){
            s[i] = temp.pop();
            i++;
        }
    }
}