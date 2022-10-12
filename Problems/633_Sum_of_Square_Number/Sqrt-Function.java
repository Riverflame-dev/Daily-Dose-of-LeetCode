/*
Algorithm:
This approach makes use of the Math.sqrt() to check if sqrt(c - a^2) turns out to be an integer.

Time complexity : O(sqrt(c) * log(c))
- We iterate over sqrt(c) for choosing an a
- For every a, finding square root of c - a^2 takes O(log c) in the worst case.

Space complexity : O(1) 
- Constant extra space is used.
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        
        // Iterate through all a in range 
        for (long a = 0; a * a <= c; a++) {
            
            // Get the desired b value
            double b = Math.sqrt(c - a * a);
            
            // See if it's an integer
            if (b == (int) b)
                return true;
        }
        return false;
    }
}
