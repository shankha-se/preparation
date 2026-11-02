class NumMatrix {

    private int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        preSumMatrix = new int[matrix.length][matrix[0].length];
        for(int r = 0 ; r <= matrix.length - 1; r++){
            for(int c = 0 ; c <= matrix[0].length - 1; c++){
                if(r == 0 && c == 0){
                    preSumMatrix[r][c] = matrix[r][c];
                }
                else if (r == 0){
                    preSumMatrix[r][c] = preSumMatrix[r][c - 1] + matrix[r][c];
                }
                else if (c == 0){
                    preSumMatrix[r][c] = preSumMatrix[r - 1][c] + matrix[r][c];
                }
                else {
                    preSumMatrix[r][c] = preSumMatrix[r][c - 1] + preSumMatrix[r - 1][c] - preSumMatrix[r - 1][c - 1] + matrix[r][c]; 
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = preSumMatrix[row2][col2];
        if(row1 == 0 && col1 == 0) {
            return totalSum;
        }
        else if (row1 == 0){
            return totalSum - preSumMatrix[row2][col1 - 1];
        }
        else if (col1 == 0){
            return totalSum - preSumMatrix[row1-1][col2];
        }
        else {
            return totalSum - preSumMatrix[row1-1][col2] - preSumMatrix[row2][col1-1] + preSumMatrix[row1-1][col1-1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */