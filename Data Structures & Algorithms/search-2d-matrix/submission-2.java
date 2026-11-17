class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLUMNS = matrix[0].length;
        int lo = 0, hi = ROWS * COLUMNS - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / COLUMNS;
            int col = mid % COLUMNS;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
