# Day 16 — #200DaysOfLeetCode
## Problem: Sqrt(x) (LeetCode 69)

Given a **non-negative integer** `x`, compute and return the **square root of `x` truncated to an integer**.  
The returned integer should be the **floor** of the true square root.

---

## Java Reference Solution (with `main`)

```java
public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == x) return mid;
            else if (sq < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SqrtX solver = new SqrtX();
        System.out.println(solver.mySqrt(4));   // 2
        System.out.println(solver.mySqrt(8));   // 2 (since sqrt(8) ~ 2.82)
        System.out.println(solver.mySqrt(0));   // 0
        System.out.println(solver.mySqrt(1));   // 1
        System.out.println(solver.mySqrt(25));  // 5
    }
}
```

---

## Algorithm (Binary Search)

1. Handle small cases: if `x < 2`, return `x`.
2. Use binary search in the range `[1, x/2]` (since sqrt(x) ≤ x/2 for x ≥ 2).
3. At each step, compute `mid = (left + right) / 2` and `sq = mid * mid`.
   - If `sq == x`, return `mid`.
   - If `sq < x`, move search to the right (`left = mid + 1`) and update `ans = mid`.
   - If `sq > x`, move search to the left (`right = mid - 1`).
4. Continue until the search finishes, return `ans` as the floor of sqrt(x).

---

## Example 1

Input:  
```
x = 4
```
**Steps**
- left=1, right=2
- mid=1 → sq=1 → < 4 → ans=1, left=2
- mid=2 → sq=4 → == 4 → return 2

**Output:**  
```
2
``` 

---

## Example 2

Input:  
```
x = 8
```
**Steps**
- left=1, right=4
- mid=2 → sq=4 → < 8 → ans=2, left=3
- mid=3 → sq=9 → > 8 → right=2
- Loop ends, return ans=2

**Output:**  
```
2
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(log x)**  
  Binary search cuts range in half each step.

- **Space Complexity:** **O(1)**  
  Only constant extra variables used.

---

## Notes
- Must use `long` for `mid*mid` to avoid overflow when `x` is large (up to 2³¹−1).
- This approach guarantees floor of sqrt without using built-in functions.
