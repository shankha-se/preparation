class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+")){
                if(stack.size() < 2){
                    return Integer.MIN_VALUE;
                }
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals("-")){
                if(stack.size() < 2){
                    return Integer.MIN_VALUE;
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            }
            else if(token.equals("*")){
                if(stack.size() < 2){
                    return Integer.MIN_VALUE;
                }
                stack.push(stack.pop() * stack.pop());
            }
            else if(token.equals("/")){
                if(stack.size() < 2){
                    return Integer.MIN_VALUE;
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2/val1);
            }
            else {
                int val = Integer.parseInt(token);
                stack.push(val);
            } 
        }
        return stack.pop();
    }
}
