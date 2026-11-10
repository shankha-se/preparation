class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String item : operations){
            if (item.equals("+")){
                int top = stack.pop();
                int secTop = stack.peek();
                int sum = top + secTop;
                stack.push(top);
                stack.push(sum);
            }
            else if (item.equals("D")){
                int mult = stack.peek() * 2;
                stack.push(mult);
            }
            else if (item.equals("C")){
                stack.pop();
            }
            else {
                int number = Integer.parseInt(item);
                stack.push(number);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}