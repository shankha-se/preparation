class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> unique = new TreeSet<Integer>();
        for(int num : nums){
            unique.add(num);
        }
        int i = 0;
        for(int val : unique){
            nums[i] = val;
            i++;
        }
        return unique.size();
    }
}