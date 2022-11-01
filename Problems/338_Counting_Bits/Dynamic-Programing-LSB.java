/*
Approach 2: DP + Least Significant Bit
- Use previous count results to generate the count for a new integer.
- transition function: P(x) = P(x / 2) + (x mod 2)

Time complexity: O(n)
- For each integer x, in the range 1 to n, we need to perform a constant number of operations which does not depend on the number of bits in x.

Space complexity: O(1). Since the output array does not count towards the space complexity.

*NOTE: x & 1 produces a value that is either 1 or 0, depending on the least significant bit of x: 
- if the last bit is 1, the result of x & 1 is 1; otherwise, it is 0. This is a bitwise AND operation.
*/

public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[x] = ans[x >> 1] + (x & 1); 
        }
        return ans;
    }
}
