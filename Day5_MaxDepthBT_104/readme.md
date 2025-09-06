# Day 5 — #200DaysOfLeetCode
## Problem: Maximum Depth of Binary Tree (LeetCode 104)

Given the `root` of a binary tree, return its **maximum depth**.  
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

---

## Java Reference Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
```

---

## Algorithm (DFS - Depth First Search)

1. **Base case**: if `root == null`, return 0 (empty tree has depth 0).
2. Recursively compute the depth of the left subtree.
3. Recursively compute the depth of the right subtree.
4. Take the maximum of the two depths and add 1 (for the current node).
5. Return this value.

---

## Example 1 — Balanced Tree

Tree:
```
        1
      /   \
     2     3
    / \
   4   5
```

**Step-by-step trace**

- Start at root `1`:
  - Go left → node `2`:
    - Go left → node `4` → children null → depth = 1
    - Go right → node `5` → children null → depth = 1
    - Depth at node `2` = 1 + max(1,1) = 2
  - Go right → node `3` → children null → depth = 1
  - Depth at root `1` = 1 + max(2,1) = 3

**Output:**  
```
3
``` 

---

## Example 2 — Skewed Tree

Tree:
```
    1
     \
      2
       \
        3
```

**Step-by-step trace**

- Start at root `1`:
  - Left is null → depth = 0
  - Right → node `2`:
    - Left is null → depth = 0
    - Right → node `3`:
      - Children null → depth = 1
    - Depth at node `2` = 1 + max(0,1) = 2
  - Depth at root `1` = 1 + max(0,2) = 3

**Output:**  
```
3
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(n)**  
  Each node is visited once.

- **Space Complexity:** **O(h)** (recursion stack)  
  - `h` = height of tree.  
  - For balanced trees → O(log n).  
  - For skewed trees → O(n).

---

## Notes
- This is a **DFS recursion approach**.  
- Iterative solutions with a queue (BFS level order) are also possible.
