/*
Approach #4 Gauss' Formula 
- By Gauss' formula, we can compute the sum of the first n natural numbers in constant time.
- The number that is missing is simply the result of Gauss' formula minus the sum of nums, as nums consists of the first n natural numbers minus some number.

Time complexity : O(n)
- Although Gauss' formula can be computed in O(1) time, summing nums costs us O(n) time
- Because we have no information about which number is missing, an adversary could always design an input for which any algorithm that examines fewer than n numbers fails. Therefore, this solution is asymptotically optimal.

Space complexity : O(1)
- This approach only pushes a few integers around, so it has constant memory usage.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
