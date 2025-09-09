# Day 8 — #200DaysOfLeetCode
## Problem: Remove Duplicates from Sorted List (LeetCode 83)

Given the `head` of a **sorted linked list**, delete all duplicates such that each element appears only once.  
Return the linked list sorted as well.

---

## Java Reference Solution

```java
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
                dummy.next = ptr ;
                dummy = dummy.next;
            }
            ptr = ptr.next;
        }
        dummy.next = null; // cut off remaining duplicates
        return ans ;
    }
}
```

---

## Algorithm

1. **Base check**: if list is empty or has one node, return it as-is.
2. Create a **dummy node** initialized with the first value.
3. Maintain two pointers:
   - `dummy` → tracks the end of the result list.
   - `ptr` → scans through the original list.
4. For each node in `ptr`:
   - If the value differs from the last unique (`dummy.val`), link it as the next node in the result.
   - Otherwise, skip it.
5. At the end, set `dummy.next = null` to cut off extra duplicate links.
6. Return the head of the cleaned list.

---

## Example 1 — From Main Function

Input Linked List:  
```
1 -> 1 -> 2 -> 3 -> 3
```

**Step-by-step trace**

- Start: `dummy = 1`, `ans = 1`, `ptr = 1 (second node)`
- Compare: 1 == 1 → skip
- Move ptr → `2`
- Compare: 2 != 1 → attach `2`, move `dummy` → `2`
- Move ptr → `3`
- Compare: 3 != 2 → attach `3`, move `dummy` → `3`
- Move ptr → `3`
- Compare: 3 == 3 → skip
- End of list, cut off next pointer.

**Output:**  
```
1 -> 2 -> 3
```

---

## Example 2 — Random Example

Input Linked List:  
```
1 -> 1 -> 1 -> 2 -> 4 -> 4 -> 5
```

**Step-by-step trace**

- Start: `dummy = 1`, skip all repeated `1`s
- Attach `2` → list: `1 -> 2`
- Attach `4` → list: `1 -> 2 -> 4`
- Skip repeated `4`
- Attach `5` → list: `1 -> 2 -> 4 -> 5`
- End.

**Output:**  
```
1 -> 2 -> 4 -> 5
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(n)**  
  Each node is visited once.

- **Space Complexity:** **O(1)**  
  No extra data structures are used; only pointers are updated.

---

## Notes
- Works because the list is **sorted**, ensuring duplicates are adjacent.  
- If the list were unsorted, we’d need a `HashSet` to track seen values.
