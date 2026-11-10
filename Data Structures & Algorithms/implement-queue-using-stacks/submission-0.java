class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;

    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        main.push(x);
    }
    
    public int pop() {
        if(main.isEmpty()){
            return Integer.MIN_VALUE;
        }
        while(main.size() > 1){
            helper.push(main.pop());
        }
        int removed = main.pop();
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }
        return removed;
    }
    
    public int peek() {
        if(main.isEmpty()){
            return Integer.MIN_VALUE;
        }
        while(main.size() > 1){
            helper.push(main.pop());
        }
        int top = main.pop();
        helper.push(top);
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return main.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */