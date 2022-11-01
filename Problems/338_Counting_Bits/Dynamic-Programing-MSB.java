/*
Approach 2: DP + Most Significant Bit
- Use previous count results to generate the count for a new integer.

Time complexity: O(n)
- For each integer x, in the range 1 to n, we need to perform a constant number of operations which does not depend on the number of bits in x.

Space complexity: O(1). Since the output array does not count towards the space complexity.
*/

public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        // initial state
        int x = 0;
        int b = 1;   // b = 2^0
    
        // to cover all the numbers from 0 to n
        while (b <= n) {
            // x < b will avoid repeating 
            while (x < b && x + b <= n) {
                ans[x + b] = ans[x] + 1;
                ++x;
            }                         
            x = 0;   // reset x
            b <<= 1; // b = 2^m, where m++
        }      
        return ans;
    }
}

/*
x < b because: 

n x+b
1 0+1
2 0+2
3 1+2
4 0+4
5 1+4
6 2+4
7 3+4
8 0+8
9 1+8
*/
