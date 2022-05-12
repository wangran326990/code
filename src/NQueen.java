class NQueen {
    /**
     def backtrack_nqueen(row = 0, count = 0):
     for col in range(n):
     # iterate through columns at the curent row.
     if is_not_under_attack(row, col):
     # explore this partial candidate solution, and mark the attacking zone
     place_queen(row, col)
     if row + 1 == n:
     # we reach the bottom, i.e. we find a solution!
     count += 1
     else:
     # we move on to the next row
     count = backtrack_nqueen(row + 1, count)
     # backtrack, i.e. remove the queen and remove the attacking zone.
     remove_queen(row, col)
     return count
     */

    int[][] chessboard;
    int[][] canAttack;
    public int totalNQueens(int n) {
        chessboard = new int[n][n];
        canAttack = new int[n][n];
        return backtrackNQueen(0,0, n);
    }

    private int backtrackNQueen(int row, int count, int n) {
        for(int col = 0; col < n; col++) {

            if(isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if(row + 1 == n)
                    count++;
                else {
                    count = backtrackNQueen(row+1,count,n);
                }
                removeQueen(row, col);

            }
        }
        return count;
    }
    public boolean isNotUnderAttack(int row, int col) {
        return canAttack[row][col] == 0;
    }

    public void placeQueen(int row,int col) {
        chessboard[row][col] = 1;
        for(int i = 0; i < chessboard[row].length; i++) {
            if(col != i) {
                canAttack[row][i] += 1;
            }
        }

        for(int i = 0; i < chessboard.length; i++) {
            if(row != i) {
                canAttack[i][col] += 1;
            }
        }
        int crow = row;
        int ccol = col;
        while(crow >= 0 && ccol >= 0) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] += 1;
            }
            crow--;
            ccol--;
        }

        crow = row;
        ccol = col;
        while(crow < canAttack.length && ccol < canAttack[0].length) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] += 1;
            }
            crow++;
            ccol++;
        }

        crow = row;
        ccol = col;
        while(crow < canAttack.length && ccol >= 0) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] += 1;
            }
            crow++;
            ccol--;
        }

        crow = row;
        ccol = col;
        while(crow >= 0 && ccol < canAttack[0].length) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] += 1;
            }
            crow--;
            ccol++;

        }
    }

    public void removeQueen(int row, int col) {
        chessboard[row][col] = 0;
        for(int i = 0; i < chessboard[row].length; i++) {
            if(col != i) {
                canAttack[row][i] -= 1;
            }
        }

        for(int i = 0; i < chessboard.length; i++) {
            if(row != i) {
                canAttack[i][col] -= 1;
            }
        }
        int crow = row;
        int ccol = col;
        while(crow >= 0 && ccol >= 0) {

            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] -= 1;
            }
            crow--;
            ccol--;
        }

        crow = row;
        ccol = col;
        while(crow < canAttack.length && ccol < canAttack[0].length) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] -= 1;
            }
            crow++;
            ccol++;

        }

        crow = row;
        ccol = col;
        while(crow < canAttack.length && ccol >= 0) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] -= 1;
            }
            crow++;
            ccol--;
        }

        crow = row;
        ccol = col;
        while(crow >= 0 && ccol < canAttack[0].length) {
            if(crow != row &&  ccol != col) {
                canAttack[crow][ccol] -= 1;
            }
            crow--;
            ccol++;
        }
    }

}