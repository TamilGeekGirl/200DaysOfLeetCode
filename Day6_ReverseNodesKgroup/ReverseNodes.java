public class ReverseNodes
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prevGroup = dummy;

        while (true) {
            // Find the k-th node from prevGroup
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) break; // not enough nodes left

            ListNode groupNext = kth.next;

            // Reverse group
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Reconnect with previous group
            ListNode newGroupHead = kth;
            ListNode newGroupTail = prevGroup.next;
            prevGroup.next = newGroupHead;
            prevGroup = newGroupTail;
        }

        return dummy.next;
    }

    // Helper: return k-th node from current position
    private ListNode getKth(ListNode node, int k) 
    {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
    public static void main(String[] args) {
        // Build linked list [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ReverseNodes sol = new ReverseNodes();
        ListNode newHead = sol.reverseKGroup(head, k);

        // Print result
        printList(newHead);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
