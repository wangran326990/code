public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        validTree(5, edges);
    }

    static class UnionFind {
        int[] root;
        int[] rank;
        int count;
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

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2) {
                count--;
                if(rank[root1] > rank[root2]) {
                    root[node2] = root1;
                }else if(rank[root2] > rank[root1]) {
                    root[node1] = root2;
                }else {
                    root[node2] = root1;
                    rank[root1]++;
                }
            }
        }
        boolean isValidTree() {
            return count == 1;
        }
    }
    public static boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.isValidTree();
    }
}
