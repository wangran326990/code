import data.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode result = new ListNode();
        ListNode temp = result;
        int len = getLength(head);
        int move = len % k;
        while(move > 0) {
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }
        temp.next = head;
        return result.next;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
