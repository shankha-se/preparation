class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int[] leftMaxHeight = new int[height.length];
        leftMaxHeight[0] = height[0];
        for(int i = 1; i < leftMaxHeight.length; i++) {
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i-1]);
        }
        int[] rightMaxHeight = new int[height.length];
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for(int j = rightMaxHeight.length - 2; j >= 0; j--) {
            rightMaxHeight[j] = Math.max(height[j], rightMaxHeight[j+1]);
        }

        int totalWater = 0;
        for(int i = 0; i < height.length; i++) {
            totalWater += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }

        return totalWater;
    }
}
