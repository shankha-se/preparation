class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }
        else if (minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return minStack.peek();
    }
}
