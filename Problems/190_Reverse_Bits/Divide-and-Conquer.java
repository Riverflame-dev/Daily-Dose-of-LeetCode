/*
Approach 3: Mask and Shift
- The idea can be considered as a strategy of divide and conquer
- where we divide the original 32-bits into blocks with fewer bits via bit masking
- then we reverse each block via bit shifting
- and at the end we merge the result of each block to obtain the final result.

Time Complexity: O(1)
- no loop is used in the algorithm.

Space Complexity: O(1)
- Actually, we did not even create any new variable in the function.

*NOTE:
f 1111 0 0000
c 1100 3 0011
a 1010 5 0101
*/

public class Solution {
    
    public int reverseBits(int num) {
        
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        
        return num;
        
    }
}
