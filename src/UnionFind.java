import java.util.PriorityQueue;

public class UnionFind {

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
