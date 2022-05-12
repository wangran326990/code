//1438
//1138
class AlphabetBoardPathSolution {
    static int[][] DIR = new int[][]{{0, 1}, {-1, 0}, {0, -1},{1,0}}; static char[] labels = new char[]{'U','L','D','R'};

    public String alphabetBoardPath(String target) {
        char[][] board = new char[][] {{'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'},
                {'z'}};
        String result = "";
        backtracking(result,target, 0, 0, board,"");
        return result;
    }


    //leet
    //eet

    public void backtracking(String result, String target, int row, int col,  char[][] board, String tempResult) {
        boolean find = false;
        if(target.isEmpty()) {
            result = result.length() > tempResult.length()? tempResult : result;
        }else {
            System.out.println(board[row][col] + "");
            if(target.startsWith(board[row][col] + "") ) {
                target.substring(1);
                find = true;
            }
            for(int[] direction : DIR) {
                int xd = direction[0];
                int yd = direction[1];
                if(row + xd >= board.length || row + xd < 0 || col + yd >= board[row].length || col + yd < 0){
                    return;

                }else {
                    backtracking(result, target, row + xd, col + yd, board, find? tempResult + "!U": tempResult + "U");
                    backtracking(result, target, row + xd, col + yd, board, find? tempResult + "!L": tempResult + "L");
                    backtracking(result, target, row + xd, col + yd, board, find? tempResult + "!D": tempResult + "D");
                    backtracking(result, target, row + xd, col + yd, board, find? tempResult + "!R": tempResult + "R");
                }
            }
        }

    }
}
public class AlphabetBoardPath {
//    public static void main(String[] args) {
//        AlphabetBoardPathSolution alphabetBoardPathSolution = new AlphabetBoardPathSolution();
//        alphabetBoardPathSolution.alphabetBoardPath()
//    }
}