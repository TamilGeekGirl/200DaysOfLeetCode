# Day 2 — #200DaysOfLeetCode
## Problem: Symmetric Tree (LeetCode 101)

Given the `root` of a binary tree, **return `true` if it is symmetric** around its center (i.e., a mirror of itself), otherwise return `false`.

A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree: for every node, the value matches and the **left child of one side mirrors the right child of the other**, and vice versa.

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
    public boolean isSymmetric(TreeNode root) 
    {
        if (root==null) return true;
        return isSymmetricCheck(root.left,root.right);
    }
    private boolean isSymmetricCheck(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true; // end of tree or leaf nodes.
        if(left==null || right==null) return false; // asymmetric
        if(left.val==right.val) 
            return isSymmetricCheck(left.left,right.right) 
                && isSymmetricCheck(left.right,right.left); // remaining checks
        else return false; // default condition.
    }
}
```

---

## Algorithm (Recursive Mirror Check)

1. **Base root check**: If `root == null`, return `true` (empty tree is symmetric).
2. **Pairwise mirror**: Call `isSymmetricCheck(root.left, root.right)`.
3. Inside `isSymmetricCheck(left, right)`:
   - If **both null** → `true` (mirrors at the leaf).
   - If **one null** → `false` (structure differs).
   - If **values differ** → `false`.
   - Otherwise, **recurse on cross children**:
     - `isSymmetricCheck(left.left, right.right)` **AND**
     - `isSymmetricCheck(left.right, right.left)`.
4. Return the conjunction of both recursive results all the way up.

This enforces both **structure** and **values** to mirror.

---

## Example 1 — Symmetric

Tree:
```
        1
      /   \
     2     2
    / \   / \
   3   4  4   3
```

**Step-by-step trace**

- Start: `isSymmetric(root)` → check `(root.left=2, root.right=2)`
- Compare values: `2 == 2` → continue
- Recurse crosswise:
  - A) `isSymmetricCheck( left.left=3 , right.right=3 )`
    - `3 == 3`
    - Children pairs: `(null,null)` and `(null,null)` → both `true`
    - A) returns **true**
  - B) `isSymmetricCheck( left.right=4 , right.left=4 )`
    - `4 == 4`
    - Children pairs: `(null,null)` and `(null,null)` → both `true`
    - B) returns **true**
- Final: `A && B` → `true && true` → **true**

**Output:** `true` ✅

---

## Example 2 — Not Symmetric (structure mismatch)

Tree:
```
        1
      /   \
     2     2
      \      \
       3      3
```

**Step-by-step trace**

- Start: `isSymmetric(root)` → check `(root.left=2, root.right=2)`
- Compare values: `2 == 2` → continue
- Recurse crosswise:
  - A) `isSymmetricCheck( left.left=null , right.right=3 )`
    - One null, one not → **false**
  - B) `isSymmetricCheck( left.right=3 , right.left=null )`
    - One null, one not → **false**
- Final: `A && B` → `false && false` → **false**

**Output:** `false` ❌

---

## Complexity Analysis

- **Time Complexity:** **O(n)**  
  We visit each node at most once in a constant amount of work per node.

- **Space Complexity:** **O(h)** (worst-case **O(n)**)  
  Due to recursion stack, where **h** is the tree height. For a balanced tree, **h = O(log n)**; for a skewed tree, it can be **O(n)**.

---

## Notes
- This is a classic mirror recursion pattern: compare **outer** and **inner** pairs.
- An iterative solution using a queue (BFS) or stack (DFS) is also possible by pushing pairs `(left, right)` and checking them in the same crosswise manner.
