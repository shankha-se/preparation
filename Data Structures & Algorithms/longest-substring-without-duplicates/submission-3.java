class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int len = 0, ans = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();
        
        while(true) {
            boolean a = false;
            boolean r = false;
            //Aquire
            while(i < s.length()){
                a = true;

                char ch = s.charAt(i);
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
                i++;

                if(frequency.get(ch) > 1){
                    break;
                }
                else {
                    len = i - j;
                    ans = Math.max(ans, len);
                }
            }
            //Release
            while(j < i){
                r = true;

                char ch = s.charAt(j);
                frequency.put(ch, frequency.getOrDefault(ch, 0) - 1);
                j++;
                if(frequency.get(ch) == 1){
                    break;
                }
            }

            if(a == false && r == false) {
                break;
            }
        }
        return ans;
    }
}
