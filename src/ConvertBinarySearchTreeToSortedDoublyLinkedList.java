import data.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {


    Node head;
    Node result;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        linkNode(root);
        result.left = head;
        head.right = result;
        return result;
    }

    public void linkNode(Node root) {
        if(root == null) return;
        linkNode(root.left);
        link(root);
        linkNode(root.right);

    }

    public void link(Node node) {
        if(head == null) {
            head = new Node(node.val);
            result = head;
        }else {
            Node next = new Node(node.val);
            next.left = head;
            head.right = next;
            head = next;
        }
    }
    /*
    Node head;
    Node prev;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        inOrder(root);

        prev.right = head;
        head.left = prev;

        return head;
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);

        if(head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        inOrder(root.right);
    }*/
}
