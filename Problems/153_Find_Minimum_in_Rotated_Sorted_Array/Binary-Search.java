/*
Approach 1: Binary Search

Time Complexity : Same as Binary Search O(logN)
Space Complexity : O(1)

*/

class Solution {
    public int findMin(int[] nums) {
        
        // Edge case when nums[] contains just one element
        if (nums.length == 1) return nums[0];
        
        // initializing left and right pointers
        // to the first elemnt and the last element
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no rotation.
        // (any rotation will result in greater elemnts at lower index since it's sorted)
        // If no rotation, the smallest element is first element. A[0]
        if (nums[right] > nums[0]) return nums[0];

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // The point of change from higher to lower value is nums[mid] to nums[mid + 1]
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];

            // if the mid element is lesser than its previous element then mid element is the smallest
            // The point of change from higher to lower value is nums[mid - 1] to nums[mid]
            if (nums[mid - 1] > nums[mid]) return nums[mid];

            // if the mid elements value is greater than the 0th element
            // then the point of change is somewhere to the right 
            // so we move the left pointer to reduce the range 
            if (nums[mid] > nums[0]) left = mid + 1;
            
            // if nums[0] is greater than the mid value 
            // then the point of change is somewhere to the left
            // so we move the right pointer to reduce the range 
            else right = mid - 1;   
        }
        
        // if the min element is not to be found
        return Integer.MAX_VALUE;
    }
}
