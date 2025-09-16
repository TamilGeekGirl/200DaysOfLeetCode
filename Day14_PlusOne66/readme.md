# Day 14 — #200DaysOfLeetCode
## Problem: Plus One (LeetCode 66)

You are given a **non-empty** array of decimal digits representing a **non-negative integer**. The most significant digit is at the front of the array.  
Increment the integer by one and return the resulting array of digits.

---

## Java Reference Solution (with `main`)

```java
import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Traverse from the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry to propagate
            }
            digits[i] = 0; // 9 becomes 0, carry continues
        }
        // If we reached here, we had a carry past the most significant digit
        int[] res = new int[digits.length + 1];
        res[0] = 1; // e.g., 999 + 1 = 1000
        return res;
    }

    public static void main(String[] args) {
        PlusOne solver = new PlusOne();

        int[] a = {1, 2, 3};     // 123 + 1 = 124
        int[] b = {9, 9, 9};     // 999 + 1 = 1000
        int[] c = {2, 9, 0, 9};  // 2909 + 1 = 2910
        int[] d = {0};           // 0 + 1 = 1

        System.out.println(Arrays.toString(solver.plusOne(a))); // [1, 2, 4]
        System.out.println(Arrays.toString(solver.plusOne(b))); // [1, 0, 0, 0]
        System.out.println(Arrays.toString(solver.plusOne(c))); // [2, 9, 1, 0]
        System.out.println(Arrays.toString(solver.plusOne(d))); // [1]
    }
}
```

---

## Algorithm

1. Start from the last index (least significant digit).
2. If the current digit is **less than 9**:
   - Increment it by 1 and **return** the array (no further carry).
3. Otherwise (digit is **9**):
   - Set it to **0** and continue to the next more significant digit (propagate carry).
4. If all digits were **9** (e.g., `999`):
   - Create a new array of length `n + 1` with the first element as `1` and return it (`1000`).

---

## Example 1 — No full carry

Input:  
```
digits = [1, 2, 3]
```
**Steps**
- i = 2 → digit = 3 < 9 → increment to 4, return.
- Array becomes `[1, 2, 4]`.

**Output:**  
```
[1, 2, 4]
``` 

---

## Example 2 — Full carry across all digits

Input:  
```
digits = [9, 9, 9]
```
**Steps**
- i = 2 → 9 → set to 0 (carry)
- i = 1 → 9 → set to 0 (carry)
- i = 0 → 9 → set to 0 (carry)
- All digits processed, allocate `[0..0]` of size 4, set first to 1 → `[1, 0, 0, 0]`

**Output:**  
```
[1, 0, 0, 0]
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(n)** — single pass from right to left.
- **Space Complexity:** **O(1)** extra space in-place, but **O(n)** in the special case where a new array is allocated (all digits are 9).

---

## Notes
- The input is already normalized (no leading zeros unless the number is zero itself).
- Works for any length, including single-element arrays like `[0]`.
