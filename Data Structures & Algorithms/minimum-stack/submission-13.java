
class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int val) {
        if (stack.size() == 0) { // First Element
            stack.push((long) val);
            min = val;
        }
        else if (val >= min) { // Value greater than or equal to min
            stack.push((long) val);
        }
        else { // Value lesser than min
            stack.push(2L * val - min);
            min = val;
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }

        long removed = stack.pop();

        if (removed < min) {
            min = min + min - removed;
        }

        if (stack.isEmpty()) {
            min = 0;
        }
    }

    public int top() {
        if (stack.size() == 0) {
            return Integer.MIN_VALUE;
        }

        if (stack.peek() < min) {
            return (int) min;
        }
        else {
            return stack.peek().intValue();
        }
    }

    public int getMin() {
        if (stack.size() == 0) {
            return Integer.MIN_VALUE;
        }

        return (int) min;
    }
}
