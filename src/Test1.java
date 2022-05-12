import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Test1 {
    public static int[][] DIRS = {{0, -1}, {0,1}, {-1, 0}, {1, 0}};
    public static char VISITED_MARKER = '$';
    private int currentCount = 0;
    public int[] solution(String[] B) {
        // write your code in Java SE 11

        TreeMap<Character, LinkedList<Integer>> freqMap = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        });
        int rows = B.length;
        int cols = B[0].length();
        char[][] board = new char[rows][cols];
        int[] res = new int[3];
        for(int i = 0; i < rows; i++) {
            String curRow = B[i];
            char[] curRowArr = curRow.toCharArray();
            for(int j = 0; j < curRowArr.length; j++) {
                board[i][j] = curRowArr[j];
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '#') {
                    int result = dfs(board, i, j, 0);
                    if(result == 1) res[0] = res[0] + 1;
                    if(result == 2) res[1] = res[1] + 1;
                    if(result == 3) res[2] = res[2] + 1;
                }
            }
        }

        return res;
    }
    private  int dfs(char[][] board, int row, int col, int count) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != '#') return count;
        count++;
        board[row][col] = VISITED_MARKER;

        for(int[] dir : DIRS) {
            dfs(board, row+dir[0], col+dir[1], count);
        }

        return count;
    }
}

class Test123 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String[] test = {".##.#", "#.#..", "#...#", "#.##."};
        test1.solution(test);
    }
}
