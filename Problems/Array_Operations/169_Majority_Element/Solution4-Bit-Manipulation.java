/*
Approach 4: Bit Manipulation

If an element majority_element occurs more than n/2 times,  then there are at least n/2 elements of identical values with num at each bit. 
That is, we can reconstruct the exact value of num by combining the most frequent value (0 or 1) at each bit.

Starting from the least significant bit, we enumerate each bit to determine which value is the majority at this bit, 0 or 1, 
and put this value to the corresponding bit of the result. 
Finally, we end up with the most least significant bit of all elements and return the result.

Time complexity: O(nlogC)
- C is the max absolute value in nums, i.e., 10^5 in this problem. We enumerate all log{C} bits for each number in nums.

Space complexity: O(1)
- We count the majority of each bit in O(1) space as it only has the two potential values, 0 and 1.
- After that, we only need to put the majority values to their corresponding bit in the returned result, and no extra space is used.

*/

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            // Count how many numbers have this bit set.
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bit_count++;
                }
            }

            // If this bit is present in more than n / 2 elements
            // then it must be set in the majority element.
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }

        return majority_element;
    }
}
