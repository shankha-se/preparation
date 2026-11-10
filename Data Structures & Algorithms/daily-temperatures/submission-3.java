class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = temperatures.length - 1; i >= 0; i--){
            int temperature = temperatures[i];
            // When smaller elemets are there then pop them
            while(!stack.isEmpty() && temperature >= temperatures[stack.peek()]) { 
                stack.pop();
            }
            // When smaller elemets are not there but still some element left
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
