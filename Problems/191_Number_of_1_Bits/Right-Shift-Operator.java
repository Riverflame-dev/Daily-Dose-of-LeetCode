/*
>> operator fills LSB bit 0 for +ve numbers and 1 for -ve numbers
>>> operator fills LSB 0 for both +ve and -ve numbers

Time Complexity: O(1).
- The run time depends on the number of bits in n. Because nn in this piece of code is a 32-bit integer, the time complexity is O(1).
Space Complexity: O(1), since no additional space is allocated.
*/

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // if n%2 = -1, -1 & 1 will still evaluate to true
            if (((n % 2) & 1) == 1) count++;
            // or just use count += (n%2) & 1;
            n >>>= 1;
        }
        return count;
    }
}
