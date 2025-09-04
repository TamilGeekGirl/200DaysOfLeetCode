# Day 4 — #200DaysOfLeetCode
## Problem: Binary Tree Zigzag Level Order Traversal (LeetCode 103)

Given the `root` of a binary tree, return the **zigzag level order traversal** of its nodes' values.  
(i.e., first level from left to right, next level from right to left, and so on).

---

## Java Reference Solution

```java
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree
{
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    levelList.addLast(node.val); // Append at the end
                } else {
                    levelList.addFirst(node.val); // Insert at the front
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagTree tree = new ZigZagTree();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println(tree.zigzagLevelOrder(root));
    }
}
```

---

## Algorithm (BFS + Direction Toggle)

1. **Base case**: if `root == null`, return empty list.
2. Use a **queue** for BFS traversal (level by level).
3. Keep a **boolean flag `leftToRight`**:
   - If `true` → append nodes to the **end** of the current level list.
   - If `false` → insert nodes at the **front** of the current level list.
4. After processing a level, toggle the flag (`leftToRight = !leftToRight`).
5. Continue until all levels are processed.

---

## Example 1 — Main Function Example

Tree:
```
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

**Step-by-step trace**

- Start: queue = `[1]`, leftToRight = true
- Level 1: `[1]` → result = `[[1]]`, toggle → false
- Level 2: nodes `[2, 3]` → insert as `[3, 2]` → result = `[[1], [3, 2]]`, toggle → true
- Level 3: nodes `[4, 5, 6, 7]` → append as `[4, 5, 6, 7]` → result = `[[1], [3, 2], [4, 5, 6, 7]]`
- Done.

**Output:**  
```
[[1], [3, 2], [4, 5, 6, 7]]
```

---

## Example 2 — Random Example

Tree:
```
        10
       /  \
      20   30
       \     \
       40     50
```

**Step-by-step trace**

- Start: queue = `[10]`, leftToRight = true
- Level 1: `[10]` → result = `[[10]]`, toggle → false
- Level 2: nodes `[20, 30]` → insert as `[30, 20]` → result = `[[10], [30, 20]]`, toggle → true
- Level 3: nodes `[40, 50]` → append as `[40, 50]` → result = `[[10], [30, 20], [40, 50]]`
- Done.

**Output:**  
```
[[10], [30, 20], [40, 50]]
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(n)**  
  Each node is visited once and inserted into a list in constant time.

- **Space Complexity:** **O(n)**  
  - Queue holds nodes of one level at a time → O(n) in the worst case (last level).  
  - The result list also stores all nodes → O(n).

---

## Notes
- This is a variation of **Level Order Traversal** where we alternate direction per level.
- A `Deque` could also be used to directly manage direction instead of inserting at head/tail.
