/*
Approach #3 Bit Manipulation XOR
- If a number is used as both an index and a value, all its bits will be turned on and then turned off. That means it has no net impact on the result since num XOR num == 0. 
- The order we apply XOR does not matter. All that matters is the total number of XOR operations were each individual bit is 1. 
- The number that is only an index but not a value will turn on all of its bits, but won't have a value that completely matches its bits.

Time complexity : O(n)
- Assuming that XOR is a constant-time operation, this algorithm does constant work on n iterations, so the runtime is overall linear.

Space complexity : O(1)
- This algorithm allocates only constant additional space.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
