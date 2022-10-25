/*
Approach 1: Binary Search
- Use binary search to find a rotation index rotation_index, i.e. index of the smallest element in the array. 
- rotation_index splits array in two parts. Compare nums[0] and target to identify in which part has the target.
- Perform a binary search in the chosen part of the array.

Time complexity : O(logN).
Space complexity : O(1).
*/

class Solution {
  int [] nums;
  int target;


  // find the index of the smallest value in the array
  public int find_rotate_index(int left, int right) {
    
    // if there is no rotation, nums[left] is the smallest value
    if (nums[left] < nums[right]) return 0;

    while (left <= right) {
        
      // mid point as pivot
      int pivot = (left + right) / 2;
        
      // if the element on the right of pivot is smaller than pivot
      // then we have found the point of change, and pivot+1 is the smallest value
      if (nums[pivot] > nums[pivot + 1])
        return pivot + 1;
    
      // if pivot to pivot+1 is accending
      // Compare pivot to the left edge to determine which half to continue 
      else {
          
        // If left > pivot < pivot + 1
        // then left > min < pivot < pivot + 1
        // we search on the left of pivot
        if (nums[pivot] < nums[left]) right = pivot - 1;
        
        // If left <= pivot < pivot + 1
        // then left < pivot < pivot + 1 > min
        // we search on the right of pivot
        else left = pivot + 1;
      }
    }
    return 0;
  }

  // Binary search
  public int search(int left, int right) {
    while (left <= right) {
      // mid point as pivot
      int pivot = (left + right) / 2;
    
      // target if found
      if (nums[pivot] == target)
        return pivot;
        
      else {
        // if target is smaller than pivot, continue to the left half
        if (target < nums[pivot]) right = pivot - 1;
          
        // if target is larger than pivot, continue to the right half
        else left = pivot + 1;
      }
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    this.nums = nums;
    this.target = target;

    int n = nums.length;

    // Edge case when there's only one elemnt in array
    if (n == 1) return this.nums[0] == target ? 0 : -1;

    // find the smallest value in array to be the pivot
    int rotate_index = find_rotate_index(0, n - 1);

    // if target is the smallest element
    if (nums[rotate_index] == target) return rotate_index;
      
    // if array is not rotated, search in the entire array
    if (rotate_index == 0) return search(0, n - 1);
      
    // if target is smaller than the first element
    // target is in the right side of the pivot
    if (target < nums[0]) return search(rotate_index, n - 1);
      
    // if target is larger than the first element
    // target is in the left side of the pivot
    return search(0, rotate_index);
  }
}
