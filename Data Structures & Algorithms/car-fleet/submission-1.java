class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[speed.length][2];
        for(int i = 0 ; i < speed.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int[] car : cars){
            double timeToReach = (double)(target - car[0]) / car[1];
            if(stack.isEmpty() || timeToReach > stack.peek()){
                stack.push(timeToReach);
            }
        }
        return stack.size();
    }
}
