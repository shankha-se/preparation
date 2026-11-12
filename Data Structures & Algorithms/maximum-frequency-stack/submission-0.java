class FreqStack {
    private Map<Integer, Integer> cnt;
    private List<Stack<Integer>> stacks;
    public FreqStack() {
        cnt = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }
    
    public void push(int val) {
        // Update frequency directly in the map without a temporary valCnt variable
        if (cnt.containsKey(val)) {
            cnt.put(val, cnt.get(val) + 1);
        } else {
            cnt.put(val, 1);
        }
        
        // Retrieve the updated frequency to place it in the correct stack tier
        int freq = cnt.get(val);

        // If this frequency exceeds our current highest frequency stack, add a new stack level
        if (freq == stacks.size()) {
            stacks.add(new Stack<>());
        }
        
        // Push the value onto the stack corresponding to its frequency count
        stacks.get(freq).push(val);
    }
    
    public int pop() {
        // Get the stack representing the highest current frequency
        Stack<Integer> topStack = stacks.get(stacks.size() - 1);
        int res = topStack.pop();
        
        // Decrement frequency count for the popped value directly
        cnt.put(res, cnt.get(res) - 1);
        
        // If the highest frequency stack becomes empty, remove it
        if (topStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */