
class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int val) {
        if (stack.isEmpty()) { // First Element
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
        if (stack.isEmpty()) { //Underflow
            min = Integer.MIN_VALUE;
            return;
        }

        long removed = stack.pop();

        if (removed < min) {
            min = min + min - removed;
        }
    }

    public int top() {
        if (stack.isEmpty()) { //Underflow
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
        if (stack.isEmpty()) { //Underflow
            return Integer.MIN_VALUE;
        }

        return (int) min;
    }
}
