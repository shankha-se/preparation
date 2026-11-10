class MyStack {
    Queue<Integer> queue;

    public MyStack() { // F - Remove and Peek, R - Add
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) { //Push Optimized
        queue.add(x);
        for(int i = 1; i <= queue.size() - 1; i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() { //Pop Optimized
        if(queue.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return queue.remove();
    }
    
    public int top() {
        if(queue.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */