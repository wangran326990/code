
public class GameOfLife {
    public static void main(String[] args) {
        int[][] test = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(test);
    }

    public static void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int next = getNextGenerationState(board, i, j, board[i][j]);
                result[i][j] = next;
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    public static int getNextGenerationState(int[][] board, int row, int col, int current) {
        int totalNeighbersLive = 0;
        //leftup
        try {
            totalNeighbersLive += board[row - 1][col - 1];
        }catch(Exception ex) {

        }

        //up
        try {
            totalNeighbersLive += board[row][col - 1];
        }catch(Exception ex) {

        }

        //rightup
        try {
            totalNeighbersLive += board[row + 1][col - 1];
        }catch(Exception ex) {

        }


        //left
        try {
            totalNeighbersLive += board[row - 1][col];
        }catch(Exception ex) {

        }

        //right
        try {
            totalNeighbersLive += board[row + 1][col];
        }catch(Exception ex) {

        }

        //leftdown
        try {
            totalNeighbersLive += board[row - 1][col + 1];
        }catch(Exception ex) {

        }

        //down
        try {
            totalNeighbersLive += board[row][col + 1];
        }catch(Exception ex) {

        }

        //rightdown
        try {
            totalNeighbersLive += board[row + 1][col + 1];
        }catch(Exception ex) {

        }
        if(current == 1) {
            if(totalNeighbersLive < 2) {
                current = 0;
            }else if(totalNeighbersLive >=2 && totalNeighbersLive <=3) {
                current = 1;
            }else {
                current = 0;
            }
        }else {
            if(totalNeighbersLive == 3) {
                current = 1;
            }
        }

        return current;
    }
}
