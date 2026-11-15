class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;
        for(String item : operations){
            if (item.equals("+")){
                int top = stack.pop();
                int secTop = stack.peek();
                int sum = top + secTop;
                stack.push(top);
                stack.push(sum);
                totalSum += sum;
            }
            else if (item.equals("D")){
                int mult = stack.peek() * 2;
                stack.push(mult);
                totalSum += stack.peek(); // Remove once and add twice = add once
            }
            else if (item.equals("C")){
                int removed = stack.pop();
                totalSum -= removed;
            }
            else {
                int number = Integer.parseInt(item);
                stack.push(number);
                totalSum += number;
            }
        }

        return totalSum;
    }
}