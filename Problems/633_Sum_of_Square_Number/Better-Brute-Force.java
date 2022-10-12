/*
This approach utilizes the theorem that:
- The square of n^th positive integer can be represented as a sum of first n odd positive integers.
- The goal is to iterate through all a within the correct range and check if there is a b such that b = c - a^2 and b is a perfect square

Time complexity : O(c)
- The total number of times the sum is updated is 1+2+3+...sqrt(c) = O(c)
- TAKES WAY TOO LONG

Space complexity : O(1) 
- Constant extra space is used.
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        
        // Iterates through all a in the range of (0, sqrt(c))
        for (long a = 0; a * a <= c; a++) {
            
            // Get the value of b^2 
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            
            // Check if b^2 is a perfect square using the theorem
            while (sum < b) {
                
                // Add odd integer to sum
                sum += i;
                
                // Increment i to the next odd integer
                i += 2;
            }
            
            // After adding together all odd integers smaller than b
            // We will know if b^2 is a perfect square
            if (sum == b)
                return true;
        }
        return false;
    }
}
