/*
Approach #2 HashSet Brute Force
- A brute force method for solving this problem would be to simply check for the presence of each number.
- The naive implementation might use a linear scan of the array to check for containment.
- but we can use a HashSet to get constant time containment queries and overall linear runtime.

Time complexity : O(n)
- Because the set allows for O(1) containment queries, the main loop runs in  O(n) time. 
- Creating num_set costs O(n) time, as each set insertion runs in amortized O(1) time, 
- so the overall runtime is O(n+n) = O(n).

Space complexity : O(n)
- nums contains n-1 distinct elements, so it costs O(n) space to store a set containing all of them.
*/

class Solution {
    public int missingNumber(int[] nums) {
        
        // HashSet for containing all numbers in nums
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        // For each number in the range [0, n] where n = nums.length + 1
        // Check if it's missing from the HashSet 
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
