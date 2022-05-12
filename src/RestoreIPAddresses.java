import java.util.PriorityQueue;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        int[][] connections = {{1,2,1},{1,3,2},{3,4,4},{1,4,3}};
        minimumCost(4, connections);
    }
    public static int minimumCost(int n, int[][] connections) {
        int maxCount = n - 1;
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((connection1, connection2)-> {
            return connection1[2] - connection1[2];
        });

        for(int[] connection : connections) {
            pq.offer(connection);
        }
        UnionFind uf = new UnionFind(n);
        while(!pq.isEmpty() && maxCount > 0) {
            int[] currentConnection = pq.poll();
            int start = currentConnection[0];
            int end = currentConnection[1];
            int cost = currentConnection[2];
            if(!uf.isConnected(start -1, end - 1)) {
                result += cost;
                maxCount--;
                uf.union(start -1, end - 1);
            }
        }
        return maxCount == 0 ? result : -1;
    }

    static class UnionFind {

        private int roots[];
        private int rank[];

        public UnionFind(int size) {
            roots = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                roots[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if(roots[node] == node) return node;
            roots[node] = find(roots[node]);
            return roots[node];
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2) {
                int rank1 = rank[root1];
                int rank2 = rank[root2];
                if (rank1 > rank2) {
                    roots[root2] = root1;
                } else if (rank1 < rank2) {
                    roots[root1] = root2;
                } else {
                    roots[root2] = root1;
                    rank[root1] += 1;
                }
            }
        }

        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
