class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] rb = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                rb[i] = heights.length;
            }
            else {
                rb[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] lb = new int[heights.length];
        stack = new Stack<>();
        stack.push(0);
        lb[0] = -1;
        for(int i = 1; i <= heights.length - 1; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                lb[i] = -1;
            }
            else {
                lb[i] = stack.peek();
            }
            stack.push(i);
        }


        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
