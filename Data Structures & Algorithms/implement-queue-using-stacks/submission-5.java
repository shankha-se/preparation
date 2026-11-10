class MyQueue {
    Stack<Integer> main;
    Stack<Integer> helper;

    public MyQueue() { // Stack : Top - Add , Remove and Peek
        main = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) { 
        while(!main.isEmpty()){
            helper.push(main.pop());
        }
        main.push(x);
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }

    }
    
    public int pop() { // Pop efficient
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
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