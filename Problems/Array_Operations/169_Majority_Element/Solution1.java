/*
Approach 1: Brute Force
A brute force algorithm solves a problem through exhaustion: it goes through all possible choices until a solution is found. 
The time complexity of a brute force algorithm is often proportional to the input size. 
Brute force algorithms are simple and consistent, but very slow.
: O(n^2)

Time complexity: O(n^2)
- The brute force algorithm contains two nested for loops that each run for nn iterations, adding up to quadratic time complexity.

Space complexity : O(1)
- The brute force solution does not allocate additional space proportional to the input size.
*/

class Solution {
    public int majorityElement(int[] nums) {
        
        // Create a count record for each element in num[]
        for (int num : nums) {
            int count = 0;
            
            // For each element in num[], 
            // iterate through the num[] again to update the count
            for (int elem : nums) {
                if (elem == num) count += 1;
            }
            
            // Return the element if the count is Majority Element
            if (count > nums.length/2) return num;
            
        }
    }
}
