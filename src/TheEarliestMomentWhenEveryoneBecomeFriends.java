import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {

    }
    static class UnionFind {
        int[] root;
        int[] rank;
        int count;
        int earliestTime;
        public UnionFind(int capacity) {
            root = new int[capacity];
            rank = new int[capacity];
            count = capacity;
            for(int i =0; i < capacity; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if(root[node] == node) return node;
            return root[node] = find(root[node]);
        }

        public void union(int x, int y, int time) {

            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                earliestTime = time;
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }
        public int getEarliestTime() {
            return earliestTime;
        }
    }

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt((int[] log) -> log[0]));

        UnionFind uf = new UnionFind(n);
        for(int[] log : logs) {
            uf.union(log[1], log[2], log[0]);
        }
        return uf.getEarliestTime();
    }
}
