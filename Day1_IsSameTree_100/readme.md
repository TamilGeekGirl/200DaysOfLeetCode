# Day 1 of #200DaysOfLeetCode  

## Problem: Same Tree (LeetCode 100)  
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.  

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.  

---

## Algorithm  
1. **Base Case 1:** If both nodes are `null`, return `true` (both trees end at the same point).  
2. **Base Case 2:** If one node is `null` but the other isn’t, return `false` (structures differ).  
3. **Recursive Step:**  
   - Check if the values of the current nodes are equal.  
   - Recursively check the left subtree of `p` with the left subtree of `q`.  
   - Recursively check the right subtree of `p` with the right subtree of `q`.  
4. Return `true` if all three conditions are satisfied; otherwise, return `false`.  

---

## Example Walkthroughs  

### Example 1  
**Input:**  
```
p:     1         q:     1
      / \              / \
     2   3            2   3
```

**Steps:**  
1. Compare root: `p.val = 1`, `q.val = 1` → equal.  
2. Go left: `p.left.val = 2`, `q.left.val = 2` → equal.  
   - Left of left: both `null` → true.  
   - Right of left: both `null` → true.  
3. Go right: `p.right.val = 3`, `q.right.val = 3` → equal.  
   - Left of right: both `null` → true.  
   - Right of right: both `null` → true.  
4. All checks return `true`.  

**Output:**  
```
true
```

---

### Example 2  
**Input:**  
```
p:     1         q:     1
      /                / \
     2                2   3
```

**Steps:**  
1. Compare root: `p.val = 1`, `q.val = 1` → equal.  
2. Go left: `p.left.val = 2`, `q.left.val = 2` → equal.  
   - Left of left: both `null` → true.  
   - Right of left: `p.left.right = null`, `q.left.right = null` → true.  
3. Go right: `p.right = null`, `q.right.val = 3`.  
   - One is `null`, the other is not → return `false`.  
4. Final result is `false`.  

**Output:**  
```
false
```

---

## Complexity Analysis  

- **Time Complexity:**  
  - Each node is visited once.  
  - If there are `n` nodes, the time complexity is **O(n)**.  

- **Space Complexity:**  
  - In the worst case (a skewed tree), the recursion stack goes `O(n)`.  
  - In the best case (a balanced tree), recursion depth is `O(log n)`.  
  - Hence, space complexity is **O(h)**, where `h` is the height of the tree.  

---
