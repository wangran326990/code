public class SudokuSolver {
    private char[][] board;

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        this.board = board;
        backtracking(board);
        System.out.println(board);
    }

//    public boolean solve(char[][] board){
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                if(board[i][j] == '.'){
//                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
//                        if(isValid(i, j, c)){
//                            board[i][j] = c; //Put c for this cell
//
//                            if(solve(board))
//                                return true; //If it's the solution return true
//                            else
//                                board[i][j] = '.'; //Otherwise go back
//                        }
//                    }
//
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    private boolean backtracking(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(i, j, c)) {
                            if(backtracking(board)) {
                                return true;
                            }else {
                                board[i][j] = '.';
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char val) {
        if (this.board[row][col] != '.') {
            return false;
        } else {
            for (int i = 0; i < this.board[row].length; i++) {
                if (this.board[row][i] == val) return false;
            }
            for (int i = 0; i < this.board.length; i++) {
                if (this.board[i][col] == val) return false;
            }
            int squareRow = row / 3;
            int squareCol = col / 3;
            for (int i = squareRow * 3; i < (squareRow + 1) * 3; i++) {
                for (int j = squareCol * 3; j < (squareCol + 1) * 3; j++) {
                    if (this.board[i][j] == val) return false;
                }
            }
            return true;
        }
    }
}
