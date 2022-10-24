/*
Time complexity: O(n)
-  The algorithm achieves linear runtime since we are going through nums only once.

Space complexity: O(1) 
- since no additional space is consumed rather than variables which keep track of the maximum product so far, the minimum product so far, current variable, temp variable, and placeholder variable for the result.

*/


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // keep track of the maximum product up to current number 
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            
            // keep track of minimum product up to current number (negative)
            // just in case a negative product latter becomes positive 
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}
