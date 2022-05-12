public class MyLinkedList {
    private int length;
    private Node head;
    private Node tail;
    public MyLinkedList() {

    }

    public int get(int index) {

        if(length <= index) return -1;
        Node current = head;
        while(index > 0) {
            current = current.next;
            index--;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if(isEmpty()) {
            this.head = newHead;
            this.tail = newHead;
        }else {
            Node currentHead = head;
            this.head = newHead;
            this.head.next = currentHead;
        }
        length++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if(isEmpty()) {
            this.head = newTail;
            this.tail = newTail;
        }else {
            this.tail.next = newTail;
            this.tail = newTail;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index > length) return;
        if(index == length){
            addAtTail(val);
            return;
        }
        Node current = head;
        while(index > 1) {
            current = current.next;
            index--;
        }
        Node newNode = new Node(val);
        Node next = current.next;
        current.next = newNode;
        newNode.next = next;
        length++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;

        if(index == 0) {
            if(head == tail) {
                head = null;
                tail = null;
            }else {
                head = head.next;
            }
        }else if(index == length - 1) {
            Node current = head;
            while(index > 1) {
                current = current.next;
                index--;
            }
            this.tail = current;
        }
        else {
            Node current = head;
            while(index > 1) {
                current = current.next;
                index--;
            }
            current.next = current.next.next;
        }
        length--;

    }

    private boolean isEmpty() {
        return length == 0;
    }

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */