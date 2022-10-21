/*
Time complexity: O(N)
- We iterate through every element of nums exactly once.

Space complexity: O(1)
- No matter how long the input is, we are only ever using 2 variables: currentSubarray and maxSubarray
*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {

            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        
        return maxSubarray;
    }
}
