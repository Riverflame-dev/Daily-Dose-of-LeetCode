/*
Approach 1: Bit by Bit

Time Complexity: O(1)
- The number of iteration is fixed regardless the input, since the integer is of fixed-size (32-bits) in our problem.

Space Complexity: O(1)
- since the consumption of memory is constant regardless the input.
*/

public class Solution {
    public int reverseBits(int n) {
        var rev = 0;
        for (int i = 0; i < 32; i++) {
            
            // bit appended to rev shift left
    	    rev <<= 1;
            // append current LSB from n to rev
            rev |= (n & 1);
            // shift n right to aquire the next bit
    	    n >>= 1;                  
        }
        return rev;
    }
}
