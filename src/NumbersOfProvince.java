import java.util.HashSet;
import java.util.Set;

public class NumbersOfProvince {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                               {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                               {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                               {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                               {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                               {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                               {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                               {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                               {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                               {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                               {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                               {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                               {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                               {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                               {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        findCircleNum(isConnected);
    }
    static class UnionFind {
        int[] root;
        int[] rank;
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if(root[node] == node) return node;
            return root[node] = find(root[node]);
        }

        public void union(int node1, int node2) {
            if(node1 == 12 || node2 == 12) {
                System.out.println("test");
            }
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2) {
                if(rank[root1] > rank[root2]) {
                    root[node2] = root1;
                }else if(rank[root1] < rank[root2]) {
                    root[node1] = root2;
                }else {
                    root[node2] = root1;
                    rank[root1]++;
                }
            }
        }
        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        public int getNumberOfConnectionGroups() {
            Set<Integer> set = new HashSet<>();
            for(int node : root) {
                if(set.contains(node)) continue;
                set.add(node);
            }
            return set.size();
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        UnionFind uf = new UnionFind(length);
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.getNumberOfConnectionGroups();
    }
}
