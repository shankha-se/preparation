class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while(left <= right) {
            // If 2 people can fit
            if(people[left] + people[right] <= limit) {
                left ++;
            }
            // Heaviest person is anyway fitting
            right --;
            // Increment boat number
            boats ++;
        }
        return boats;
    }
}