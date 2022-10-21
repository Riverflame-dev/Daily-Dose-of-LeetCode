/*
Time complexity: O(N^2)
Space complexity: O(1)
- No matter how big the input is, we are only ever using 2 variables: ans and currentSubarray.

*/ 


class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        
        // considers each index of the array as a starting point
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            
            // consider each subarray and keep track of the max
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        
        return maxSubarray;
    }
}
