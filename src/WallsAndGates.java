import java.util.LinkedList;
import java.util.Queue;

class WallsAndGatesSolution {
    public static final int[][] DIRS = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < rooms.length; row++) {
            for(int col = 0; col < rooms[0].length; col++) {
                if(rooms[row][col] == 0) {
                    int[] gatePos = {row, col};
                    queue.offer(gatePos);
                }
            }
        }

        int curStep = 0;
        while(!queue.isEmpty()) {
            curStep++;
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++) {
                int[] curPos = queue.poll();
                int row = curPos[0];
                int col = curPos[1];
                for(int[] direction : DIRS) {
                    int curRow = row + direction[0];
                    int curCol = col + direction[1];
                    if(curRow >= 0 && curRow < rooms.length && curCol >= 0 && curCol < rooms[0].length) {
                        if(rooms[curRow][curCol] == Integer.MAX_VALUE || rooms[curRow][curCol] > curStep) {
                            rooms[curRow][curCol] = curStep;
                            queue.offer(new int[]{curRow, curCol});
                        }
                    }
                }
            }

        }
        return;
    }
}

//[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
public class WallsAndGates {
    public static void main(String[] args) {
        WallsAndGatesSolution wallsAndGatesSolution = new WallsAndGatesSolution();
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGatesSolution.wallsAndGates(rooms);
        System.out.println(rooms);
    }
}
