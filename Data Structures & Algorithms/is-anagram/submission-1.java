class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
        for (int i = 0 ; i <= s.length() - 1; i++) {
            if (map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }
            else {
                map1.put(s.charAt(i), 1);
            }
        }

        HashMap<Character,Integer> map2 = new HashMap<Character,Integer>();
        for (int i = 0 ; i <= t.length() - 1; i++) {
            if (map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }
            else {
                map2.put(t.charAt(i), 1);
            }
        }

        return map1.equals(map2);
    }

}