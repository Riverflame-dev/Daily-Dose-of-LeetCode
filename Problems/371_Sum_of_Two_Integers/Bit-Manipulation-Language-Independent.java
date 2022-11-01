/*
Approach 1: Bit Manipulation: Easy and Language-Independent
- reducing the problem down to two simple cases:
    Sum of absolute values: x + y, where x > y.
    Difference of absolute values: x - y, where x > y.
- sum without carry = x^y
- carry = (x&y)<<1.

Time complexity: O(1) because each integer contains 32 bits.

Space complexity: O(1) because we don't use any additional data structures.

*/


class Solution {
    public int getSum(int a, int b) {
        
        int x = Math.abs(a), y = Math.abs(b);
        // ensure that abs(a) >= abs(b)
        if (x < y) return getSum(b, a);
        
        // abs(a) >= abs(b) --> 
        // number with greater absolute value determines the sign
        int sign = a > 0 ? 1 : -1;
        
        // if two numbers of same sign
        // sum is the sum of their absolute value x + y
        if (a * b >= 0) {

            // x^y^carry^carry...untill there is no carry 
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                
                // in order to do (x^y)^carry with just x^y in the next iteration
                // keep track of the current x^y with x
                x = answer;
                // keep track of the current carry with y
                y = carry;    
            }  
            
        // if two numbers of different sign
        // sum is the difference of their absolute value  x - y
        // where x > y
        } else {
            while (y != 0) {
                int answer = x ^ y;
                int borrow = ((~x) & y) << 1; // this only works if x > y
                x = answer;
                y = borrow;    
            }    
        }
        return x * sign;
    }
}
