/*
Approach #1 Sorting

Time complexity : O(nlgn)
- The only elements of the algorithm that have asymptotically nonconstant time complexity are the main for loop (which runs in O(n) time), and the sort invocation (which runs in O(nlgn) time for Python and Java).
- Therefore, the runtime is dominated by sort, and the entire runtime is O(nlgn).

Space complexity : O(1) (or O(n))
- In the sample code, we sorted nums in place, allowing us to avoid allocating additional space. 
- If modifying nums is forbidden, we can allocate an O(n) size copy and sort that instead.
*/

class Solution {
    public int missingNumber(int[] nums) {
        // If nums were in order, it would be easy to see which number is missing.
        Arrays.sort(nums);

        // Check the two special cases that can be handled in constant time
        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) return nums.length;
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) return 0;

        // If we get here, then the missing number is on the range (0, n)
        // Check that the number we expect to be at each index is indeed there 
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }
}
