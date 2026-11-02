class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        // 1. Change key type from HashMap to String (using frequency counts)
        HashMap<String, List<String>> bigMap = new HashMap<>(); 
        
        for(int i = 0; i < strs.length; i++) { // 2. Fixed strs.length() to strs.length
            String str = strs[i];
            
            // Build frequency array for 26 lowercase English letters
            int[] count = new int[26];
            for(char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            // Convert count array to a unique string key
            String freqKey = Arrays.toString(count);

            if(bigMap.containsKey(freqKey)) { // 3. Fixed bigmap capitalization
                List<String> getVal = bigMap.get(freqKey);
                getVal.add(str);
                // bigMap.put is not strictly needed here since getVal points to the list in the map, 
                // but keeping your flow intact works fine!
            }
            else {
                List<String> newVal = new ArrayList<>(); // 4. Fixed List interface instantiation
                newVal.add(str);
                bigMap.put(freqKey, newVal); // 5. Added the missing map insertion!
            }
        }
        
        for(List<String> val : bigMap.values()){
            result.add(val);
        }
        return result;
    }
}