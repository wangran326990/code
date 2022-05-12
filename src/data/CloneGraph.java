package data;

import java.util.*;

public class CloneGraph {


// Definition for a Node.
static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    static class Solution {
        public Node cloneGraph(Node node) {
            Map<Integer, Node> nodeMap = new HashMap<>();
            Stack<Node> stack = new Stack<>();
            Set<Node> visited = new HashSet<>();
            stack.push(node);
            while(!stack.isEmpty()) {
                Node current = stack.pop();
                Node currentClone = nodeMap.getOrDefault(current.val, new Node(current.val));
                nodeMap.put(current.val, currentClone);
                if(visited.contains(current)) continue;
                visited.add(current);
                for(Node neighbor : current.neighbors) {
                    Node neighborClone = nodeMap.getOrDefault(neighbor.val, new Node(neighbor.val));
                    stack.push(neighbor);
                    currentClone.neighbors.add(neighborClone);
                    nodeMap.put(neighborClone.val, neighborClone);
                }
            }
            Node clonedNode = nodeMap.get(node.val);
            return clonedNode;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        solution.cloneGraph(node1);
    }
}
