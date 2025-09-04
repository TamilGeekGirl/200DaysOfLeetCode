# Day 3 — #200DaysOfLeetCode
## Problem: Binary Tree Level Order Traversal (LeetCode 102)

Given the `root` of a binary tree, return the **level order traversal** of its nodes' values.  
(i.e., from left to right, level by level).

---

## Java Reference Solution

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
```

---

## Algorithm (BFS - Breadth First Search)

1. **Initialize** an empty result list `res`.
2. **Handle base case**: if `root == null`, return `res`.
3. Use a **queue (FIFO)** to store nodes at the current level.
4. While the queue is not empty:
   - Get the size of the queue = number of nodes in the current level.
   - Create an empty list `level` to store values of this level.
   - For each node in this level:
     - Dequeue a node and add its value to `level`.
     - If it has a left child → enqueue it.
     - If it has a right child → enqueue it.
   - After processing this level, add `level` to `res`.
5. Return `res`.

---

## Example 1 — Balanced Tree

Tree:
```
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

**Step-by-step trace**

- Queue initially: `[1]`
- Level 1: dequeue `1` → `[1]`, enqueue `2, 3`
- Queue: `[2, 3]`
- Level 2: dequeue `2, 3` → `[2, 3]`, enqueue `4, 5, 6, 7`
- Queue: `[4, 5, 6, 7]`
- Level 3: dequeue `4, 5, 6, 7` → `[4, 5, 6, 7]`, enqueue nothing
- Queue empty → stop

**Output:**  
```
[ [1], [2, 3], [4, 5, 6, 7] ]
``` 

---

## Example 2 — Skewed Tree (Only Left Children)

Tree:
```
    1
   /
  2
 /
3
```
**Step-by-step trace**

- Queue initially: `[1]`
- Level 1: dequeue `1` → `[1]`, enqueue `2`
- Queue: `[2]`
- Level 2: dequeue `2` → `[2]`, enqueue `3`
- Queue: `[3]`
- Level 3: dequeue `3` → `[3]`, enqueue nothing
- Queue empty → stop

**Output:**  
```
[ [1], [2], [3] ]
```

---

## Complexity Analysis

- **Time Complexity:** **O(n)**  
  Each node is enqueued and dequeued exactly once.

- **Space Complexity:** **O(n)**  
  The queue can hold at most `n` nodes in the worst case (last level of the tree).

---

## Notes
- This solution uses **BFS (level by level traversal)**.  
- A **DFS solution** is also possible by tracking depth, but BFS with a queue is more intuitive here.
