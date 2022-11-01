/*
Java
Java integer is a number of 32 bits. 31 bits are used for the value. 
We can use the following code which assumes 32-bit for integer
*/
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        
        return a;
    }
}

/*
Python3
Python has no 32-bits limit, and hence its representation of negative integers is entirely different.
There is no Java magic by default, and if you need a magic - just do it:
After each operation we have an invisible & mask, where mask = 0xFFFFFFFF, i.e. bitmask of 32 1-bits.
The overflow, i.e. the situation of x > 0x7FFFFFFF (bitmask of 31 1-bits), is managed as x --> ~(x ^ 0xFFFFFFFF).

class Solution:
    def getSum(self, a: int, b: int) -> int:
        mask = 0xFFFFFFFF
        
        while b != 0:
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask
        
        max_int = 0x7FFFFFFF
        return a if a < max_int else ~(a ^ mask)

*/
