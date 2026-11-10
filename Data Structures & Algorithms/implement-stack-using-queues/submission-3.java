class MyStack {
    Queue<Integer> main;
    Queue<Integer> helper;

    public MyStack() { // F - Remove and Peek, R - Add
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    
    public void push(int x) { //Push Optimized
        main.add(x);
    }
    
    public int pop() { 
        if(main.isEmpty()){
            return Integer.MIN_VALUE;
        }
        while(main.size() > 1) {
            helper.add(main.remove());
        }
        int removed = main.remove();
        while(!helper.isEmpty()) {
            main.add(helper.remove());
        }
        return removed;
    }
    
    public int top() {
        if(main.isEmpty()){
            return Integer.MIN_VALUE;
        }
        while(main.size() > 1) {
            helper.add(main.remove());
        }
        int top = main.peek();
        helper.add(main.remove());
        while(!helper.isEmpty()) {
            main.add(helper.remove());
        }
        return top;
    }
    
    public boolean empty() {
        return main.isEmpty();
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