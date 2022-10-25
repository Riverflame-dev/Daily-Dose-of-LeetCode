/*
Approach 2: One-pass Binary Search
- Instead of going through the input array in two passes, we could achieve the goal in one pass with an revised binary search.
- The idea is that we add some additional condition checks in the normal binary search in order to better narrow down the scope of the search.

Time complexity : O(logN).
Space complexity : O(1).
*/

class Solution {
  public int search(int[] nums, int target) {
    // start and end pointers
    int start = 0, end = nums.length - 1;
      
    while (start <= end) {
        
      // mid point as pivot
      int mid = start + (end - start) / 2;
    
      // the job is done
      if (nums[mid] == target) return mid;
    
      // if the left side of pivot is non-rotated
      else if (nums[mid] >= nums[start]) {
         
        // if target is in the left half, continue binary search in the left half
        if (target >= nums[start] && target < nums[mid]) end = mid - 1;
        // otherwise, continue binary search in the right half
        else start = mid + 1;
      }
    
      // if the right side of pivot is non-rotated
      else {
          
        // if target is in the right half, continue binary search in the right half
        if (target <= nums[end] && target > nums[mid]) start = mid + 1;
        // otherwise, continue binary search in the left half
        else end = mid - 1;
      }
    }
    return -1;
  }
}
