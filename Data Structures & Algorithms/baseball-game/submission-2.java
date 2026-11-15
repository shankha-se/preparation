class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op : operations) {
            if(!st.isEmpty() && op.equals("D")) {
                st.push(2 * st.peek());
            }
            else if(!st.isEmpty() && op.equals("C")) {
                st.pop();
            }
            else if(st.size() > 1 && op.equals("+")) {
                int temp = st.pop();
                int sum = temp + st.peek();
                st.push(temp);
                st.push(sum);
            }
            else {
                st.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for(int x : st) {
            sum += x;
        }
        return sum;
    }
}