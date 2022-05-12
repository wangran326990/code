import data.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = head;
        ListNode rightNode = head;
        ListNode preLeftNode = null;
        ListNode postRightNode = null;
        for(int i = 1; i < left && leftNode.next != null; i++) {
            preLeftNode = leftNode;
            leftNode = leftNode.next;
        }

        for(int i = 1; i < right && rightNode.next != null; i++) {
            rightNode = rightNode.next;
        }
        postRightNode = rightNode.next;
        ListNode reversedList = reverseList(leftNode, rightNode);
        if(preLeftNode != null) preLeftNode.next = reversedList;
        leftNode.next = postRightNode;
        return preLeftNode == null? reversedList : head;
    }

    public ListNode reverseList(ListNode start, ListNode end) {
        if(start == null || start == end || start.next == null) return start;
        ListNode next = start.next;

        ListNode newHead = reverseList(next, end);
        next.next = start;
        start.next = null;
        return newHead;
    }
}
