class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[speed.length][2];
        for(int i = 0 ; i < speed.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        double currentMaxTime = 0.0;
        int fleet = 0;

        for(int[] car : cars){
            double timeToReach = (double)(target - car[0]) / car[1];
            if(timeToReach > currentMaxTime) {
                currentMaxTime = timeToReach;
                fleet++;
            }
        }
        return fleet;
    }
}
