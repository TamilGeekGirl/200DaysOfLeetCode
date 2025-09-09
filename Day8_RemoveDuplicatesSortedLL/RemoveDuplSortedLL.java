public class RemoveDuplSortedLL
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null){
            return head ;
        }

        ListNode dummy = new ListNode(head.val);
        ListNode  ans = dummy ;

        ListNode ptr = head.next ;

        while(ptr!=null){
            if(ptr.val!=dummy.val){
                // ListNode temp = new ListNode(ptr.val);
                dummy.next = ptr ;
                dummy = dummy.next;
            }
            ptr = ptr.next;
        }
        dummy.next = null; //extra line of new approach
        return ans ;
        
    }
    public static void main(String[] args) 
    {
        // Build sorted linked list with duplicates: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplSortedLL solution = new RemoveDuplSortedLL();
        ListNode result = solution.deleteDuplicates(head);

        // Print result
        System.out.print("Linked List after removing duplicates: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
