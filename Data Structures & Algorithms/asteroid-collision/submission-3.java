
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int diff = a + stack.peek();
                if (diff < 0){
                    stack.pop();
                }
                else if (diff > 0) {
                    destroyed = true;
                    break;
                }
                else {
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed){
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        } 
        return result;
    }
}
