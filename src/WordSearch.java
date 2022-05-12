public class WordSearch {
    static class WordSearchSolution {
        private int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        public boolean exist(char[][] board, String word) {
            char[] wordArr = word.toCharArray();

            boolean result = false;
            for(int i = 0; i < board.length; i++) {
                for(int j =0; j < board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(wordArr[0] == board[i][j] && dfs(0, i, j, board, wordArr, visited))
                        return true;
                }
            }
            return result;
        }

        private boolean dfs(int start, int x, int y, char[][] board, char[] word, boolean[][] visited) {

            if(x > board.length - 1 || x < 0 || y > board[0].length - 1 || y < 0 || word[start] != board[x][y] || visited[x][y]) return false;
            if(start == word.length - 1)
                return true;
            visited[x][y] = true;
            for(int[] dir : DIRS) {
                if(dfs(start + 1, x + dir[0], y + dir[1], board, word, visited)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        WordSearchSolution solution = new WordSearchSolution();
        solution.exist(board, word);
    }
}
