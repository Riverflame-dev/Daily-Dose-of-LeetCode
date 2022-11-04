/*
Approach 1: Dynamic Programming
- we have to make decisions that may depend on previously made decisions, which is very typical of a problem involving subsequences.
- we need some function or array that represents the answer to the problem from a given state. 
- we need a way to transition between states, such as dp[5] and dp[7]. This is called a recurrence relation 

Time complexity: O(N^2)
- We use two nested for loops resulting in 1 + 2 + 3 + 4 + ... + N = (N * (N + 1)) / 2 operations

Space complexity: O(N)
- The only extra space we use relative to input size is the dp array, which is the same length as nums.

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // dp[i] represents the length of the longest increasing subsequence 
        // that ends with the i^{th} element. 
        int[] dp = new int[nums.length];
        
        // initialize every element of dp to 1, since every element on its own is
        // technically an increasing subsequence.
        Arrays.fill(dp, 1);
        
        // Iterate through the elements in nums
        for (int i = 1; i < nums.length; i++) {
            
            // if nums[i] > nums[j], we can append nums[i] to the subsequence that ends with nums[j]
            // hence dp[j] determines dp[i] for each element
            // we check all the nums[j] to get the maximum length 
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }
}
