/*
For any number nn, doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0.

Time Complexity: O(1).
- The run time depends on the number of bits in n. Because nn in this piece of code is a 32-bit integer, the time complexity is O(1).
Space Complexity: O(1), since no additional space is allocated.
*/

public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
