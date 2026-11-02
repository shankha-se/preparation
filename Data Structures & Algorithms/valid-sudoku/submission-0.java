class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row ++) {
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                char val = board[row][j];
                if(val == '.') {
                    continue;
                } 
                else if(seen.contains(val)) {
                    return false;
                }
                else {
                    seen.add(val);
                }
            }
        }

        for(int col = 0; col < 9; col ++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                char val = board[i][col];
                if(val == '.') {
                    continue;
                } 
                else if(seen.contains(val)) {
                    return false;
                }
                else {
                    seen.add(val);
                }
            }
        }

        for(int box = 0; box < 9; box ++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = ( box / 3 ) * 3 + i;
                    int col = ( box % 3 ) * 3 + j;
                    char val = board[row][col];
                    if(val == '.') {
                        continue;
                    } 
                    else if(seen.contains(val)) {
                        return false;
                    }
                    else {
                        seen.add(val);
                    }
                }
            }
        }
        return true;
    }
}
