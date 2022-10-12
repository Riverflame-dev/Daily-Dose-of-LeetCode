/*
Algorithm:
- Use two pointers to scan the array from both ends.
- we can choose to increase or decrease our current sum however we like.

Time Complexity: O(n)
Space Complexity: O(1)

*/


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // Left pointer at beginning of array
        int left = 0;
        // Right pointer at end of array
        int right = numbers.length - 1;
        
        // If they meet, there is no solution
        while (left < right) {
            
            // Add the int value at the two pointers
            int sum = numbers[left] + numbers[right];
            
            // If their sum is greater than the target
            // move right pointer down to the next lower value to decreace the sum
            if (sum > target) {
                right--;
            
            // If their sum is less than the target
            // move right pointer up to the next heigher value to increace the sum
            } else if (sum < target) {
                left++;
            
            // If their sum is the target, we are done!
            } else {
                
                // Return the indices of the two numbers
                return new int[] {left+1, right+1};
            }
            
        }
        
        // When there's no solution
        return null;
    }
}
