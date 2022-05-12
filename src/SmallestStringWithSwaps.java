import java.util.*;

public class SmallestStringWithSwaps {
//    static class  Solution {
//        private int[] parent;
//        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//            if (s == null || s.length() == 0) {
//                return null;
//            }
//            parent = new int[s.length()];
//            for (int i = 0; i < parent.length; i++) {
//                parent[i] = i;
//            }
//
//            for (List<Integer> pair : pairs) {
//                union(pair.get(0), pair.get(1));
//            }
//
//            Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
//            char[] sChar = s.toCharArray();
//            for (int i = 0; i < sChar.length; i++) {
//                int root = find(i);
//                map.putIfAbsent(root, new PriorityQueue<>());
//                map.get(root).offer(sChar[i]);
//            }
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < sChar.length; i++) {
//                sb.append(map.get(find(i)).poll());
//            }
//            return sb.toString();
//        }
//        private int find(int index) {
//            while (parent[index] != index) {
//                parent[index] = parent[parent[index]];
//                index = parent[index];
//            }
//            return index;
//        }
//        private void union(int a, int b) {
//            int aParent = find(a);
//            int bParent = find(b);
//            if (aParent < bParent) {
//                parent[bParent] = aParent;
//            } else {
//                parent[aParent] = bParent;
//            }
//        }
//    }

   static class Solution {
        class UnionFind {
            int[] root;
            int[] rank;
            String s;
            Map<Integer, PriorityQueue<Character>> rootMap = new HashMap<>();
            public UnionFind(int size, String s) {
                root = new int[size];
                rank = new int[size];
                for(int i = 0; i < size; i++) {
                    root[i] = i;
                    rank[i] = 1;
                }
                this.s = s;
            }

            public int find(int node) {
                if(root[node] == node) return node;
                return root[node] = find(root[node]);
            }

            public void union(int node1, int node2) {
                int root1 = root[node1];
                int root2 = root[node2];
                if(root1 != root2) {
                    if(rank[root1] > rank[root2]) {
                        root[root2] = root1;
                    }else if(rank[root1] < rank[root2]) {
                        root[root1] = root2;
                    }else {
                        root[root2] = root1;
                        rank[root1]++;
                    }
                }
            }

            public Map<Integer, PriorityQueue<Character>> getRootMap() {
                char[] charArr = this.s.toCharArray();
                for(int i = 0; i < charArr.length; i++) {
                    int root = find(i);
                    char childChar = charArr[i];
                    PriorityQueue<Character> pq = rootMap.getOrDefault(root, new PriorityQueue<>());
                    pq.offer(childChar);
                    rootMap.put(root,  pq);
                }
                return rootMap;
            }

        }
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            UnionFind uf = new UnionFind(s.length(), s);
            for(List<Integer> pair : pairs) {
                uf.union(pair.get(0), pair.get(1));
            }
            Map<Integer, PriorityQueue<Character>> rootMap = uf.getRootMap();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(rootMap.get(uf.find(i)).poll());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        solution.smallestStringWithSwaps("dcab", pairs);
    }
}
