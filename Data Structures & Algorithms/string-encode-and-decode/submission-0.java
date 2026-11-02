class Solution {

    public String encode(List<String> strs) {
        String delimeter = "#";
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs){
            encodedString.append(str.length()).append(delimeter).append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i,j));
            i = j;
        }
        return res;
    }
}
