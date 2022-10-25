/*
Approach 2: One-pass Binary Search
- The idea is that we add some additional condition checks in the normal binary search in order to better narrow down the scope of the search.
- Use the fact that half of the array (left or right half to the pivot) is sorted, to better identify where the target is in.
- Binary search works by dividing the sorted elements into two groups. We check the arr[mid] if it is the target. 
  If it is not, the next step is to exclude one half of elements and search in the other. Thus leading to a TC of O(log n).

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
