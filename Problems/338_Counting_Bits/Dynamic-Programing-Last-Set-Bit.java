/*
Approach 2: DP + Last Set Bit
- Use previous count results to generate the count for a new integer.
- With the same logic as previous approaches, we can also manipulate the last set bit.
- transition function: P(x) = P(x & (x−1)) + 1

Time complexity: O(n)
- For each integer x, in the range 1 to n, we need to perform a constant number of operations which does not depend on the number of bits in x.

Space complexity: O(1). Since the output array does not count towards the space complexity.

*NOTE: 
x       = 01011000
x-1     = 01010111
x&(x-1) = 01010000

What happened?
- all the zeroes at the right of x remain zero;
- the rightmost 1 of x becomes a 0 because of x-1;
- all other bits are unaffected, because they are the same in x and x-1.

Conclusion: we have zeroed the rightmost 1 of x, and left all other bits unaffected.
*/

public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }
}
