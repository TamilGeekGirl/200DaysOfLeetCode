# Day 6 of #200daysofleetcode Reverse Nodes in k-Group (LeetCode 25)

##  Problem Statement
Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.  

- If the number of nodes is not a multiple of `k`, then the remaining nodes at the end should stay as-is.
- You may not alter the values in the list’s nodes, only the nodes themselves may be changed.

### Example
**Input**:  
```
head = [1,2,3,4,5], k = 2
```
**Output**:  
```
[2,1,4,3,5]
```

---

## Approach
We solve the problem in **O(n)** time and **O(1)** space using an **in-place reversal** approach:

1. **Dummy Node**: Use a dummy node before the head to simplify edge cases (like reversing the first group).
2. **Group Checking**: Before reversing, ensure at least `k` nodes remain (`getKth` helper).
3. **In-Place Reversal**: Reverse the group of size `k` by re-pointing `next` pointers.
4. **Re-link Groups**: Connect the end of the previous group to the new reversed group.
5. **Repeat** until fewer than `k` nodes remain.

---

##  Complexity Analysis
- **Time Complexity**:  
  Each node is visited **exactly once**, so **O(n)**.  
- **Space Complexity**:  
  Only a few pointers are used, so **O(1)**.

---

##  Code Implementation

```java
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
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
    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
```

---

## 🧪 Main Function for Testing

```java
public class Main {
    public static void main(String[] args) {
        // Build linked list [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        Solution sol = new Solution();
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
```

###  Example Run
**Input**:  
```
head = [1,2,3,4,5], k = 2
```

**Output**:  
```
2 -> 1 -> 4 -> 3 -> 5
```
