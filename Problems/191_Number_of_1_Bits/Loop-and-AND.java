/*
Approach 1: Loop and Flip

Time Complexity: O(1).
- The run time depends on the number of bits in n. Because nn in this piece of code is a 32-bit integer, the time complexity is O(1).

Space Complexity: O(1), since no additional space is allocated.

*/

public class Solution {
    
    // treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // check the i th bit of n using a bit mask. 
            int mask = 1 << i;
            if ((n & mask) !=0) count++;
        }
        
        return count;
    }
}
