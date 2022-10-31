/*
Approach 1: Two Pointers
- To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.
- After sorting the array, we move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

Time Complexity: O(n^2)
- twoSumII is O(n), and we call it n times.
- Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2), asymptotically equivalent to O(n^2).

Space Complexity: from O(logn) to O(n)
- depending on the implementation of the sorting algorithm. 
- For the purpose of complexity analysis, we ignore the memory required for the output.
*/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList();
        
        for (int i = 0; i < nums.length-2; i++) {
            
            // Skip if we found duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];
                
                // Perform two sum in nums[i+1, length-1] for each pivot nums[i]
                while (low < high) {
                    
                    // Once we found the triplet, add to the output list
                    if (nums[low] + nums[high] == sum) {
                        output.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                        // skip all the duplicated numbers
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;

                        // update low and high at the end of each iteration
                        low++;
                        high--;
                    
                    // if we need the sum to be smaller, make the higher number smaller
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    
                    // if we need the sum to be bigger, make the lower number greater
                    } else {
                        low++;
                    }
                }
            }
        }
        
        return output;
    }
}
