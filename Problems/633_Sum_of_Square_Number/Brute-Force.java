/*
Iterate through all integer in the range of (0, sqrt(c)) 
and check check if the sum of their squares equals c

Time complexity : O(c). 
- Two loops upto sqrt(c) Here, c refers to the given integer(sum of squares).
- TAKES WAY TOO LONG

Space complexity : O(1). 
- Constant extra space is used.
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        
        // Make sure a is in the range (0, sqrt(c))
        for (long a = 0; a * a <= c; a++) {
            
            // Make sure b is in the range (0, sqrt(c))
            for (long b = 0; b * b <= c; b++) {
                
                // Check if the sum of their squares equals c
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }
}
