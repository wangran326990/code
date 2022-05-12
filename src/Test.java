import data.ListNode;

public class Test {
    public static void main(String[] args) {
        /*
        System.out.println(validPalindrome(
                "deeee"));


        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RotateList rotateList = new RotateList();
        rotateList.rotateRight(head,2);
        //reverseList(head);

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        reverseLinkedListII.reverseBetween(head, 1, 2);
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);



        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = {{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
        networkDelayTime.networkDelayTime(times, 5,3);

        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int[][] flights = {{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
        cheapestFlightsWithinKStops.findCheapestPrice(11,flights,0,2,4);

        CheckIfNandItsDoubleExist checkIfNandItsDoubleExist = new CheckIfNandItsDoubleExist();
        int[] test = {10,2,5,3};
        checkIfNandItsDoubleExist.checkIfExist(test);

         */
        int[] arr = {3,1,2};
        SumofSubarrayMinimums sumofSubarrayMinimums = new SumofSubarrayMinimums();
        sumofSubarrayMinimums.sumSubarrayMins(arr);
        sumofSubarrayMinimums.sumSubarrayMaxs(arr);
    }

    static int delCount = 1;
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(startChar == endChar) {
                start++;
                end--;
            }else {
                if(delCount > 0) {
                    delCount--;
                    return validPalindrome(s.substring(start + 1, end + 1)) || validPalindrome(s.substring(start, end));
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
