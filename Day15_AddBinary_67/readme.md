# Day 15 — #200DaysOfLeetCode
## Problem: Add Binary (LeetCode 67)

Given two binary strings `a` and `b`, return **their sum as a binary string**.

---

## Java Reference Solution (with `main`)

```java
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solver = new AddBinary();

        String a1 = "11", b1 = "1";        // 3 + 1 = 4 -> "100"
        String a2 = "1010", b2 = "1011";   // 10 + 11 = 21 -> "10101"
        String a3 = "0", b3 = "0";         // 0 + 0 = 0 -> "0"
        String a4 = "111", b4 = "111";     // 7 + 7 = 14 -> "1110"

        System.out.println(solver.addBinary(a1, b1)); // "100"
        System.out.println(solver.addBinary(a2, b2)); // "10101"
        System.out.println(solver.addBinary(a3, b3)); // "0"
        System.out.println(solver.addBinary(a4, b4)); // "1110"
    }
}
```

---

## Algorithm

1. Start from the **end of both strings** (`i`, `j` pointers).
2. Maintain a **carry** variable (0 or 1).
3. For each step:
   - Add digits from `a` and `b` if within bounds.
   - Add the `carry`.
   - Append `(sum % 2)` to the result string.
   - Update `carry = sum / 2`.
4. After loop ends, if carry is `1`, append it.
5. Reverse the result string and return.

---

## Example 1

Input:  
```
a = "11", b = "1"
```
**Steps**
- i=1, j=0 → sum = (1+1) = 2 → append 0, carry=1
- i=0, j=-1 → sum = (1+carry=2) → append 0, carry=1
- no digits left → append carry=1
- Reverse → "100"

**Output:**  
```
"100"
``` 
---

## Example 2

Input:  
```
a = "1010", b = "1011"
```
**Steps**
- i=3, j=3 → 0+1=1 → append 1, carry=0
- i=2, j=2 → 1+1=2 → append 0, carry=1
- i=1, j=1 → 0+0+carry=1 → append 1, carry=0
- i=0, j=0 → 1+1=2 → append 0, carry=1
- carry=1 → append 1
- Reverse → "10101"

**Output:**  
```
"10101"
``` 

---

## Complexity Analysis

- **Time Complexity:** **O(max(m, n))**  
  where `m` and `n` are lengths of `a` and `b`.

- **Space Complexity:** **O(max(m, n))**  
  Result string builder stores at most `max(m,n) + 1` characters.

---

## Notes
- This is a standard implementation of binary addition.
- The approach works similarly to how you’d do manual addition on paper.
