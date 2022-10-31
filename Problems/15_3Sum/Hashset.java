/*
Approach 2: Hashset
- To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.
- After sorting the array, we move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the Two Sum: One-pass Hash Table approach, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

Time Complexity: O(n^2)
- twoSumII is O(n), and we call it n times.
- Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2), asymptotically equivalent to O(n^2).

Space Complexity: O(n)
- for the hashset.

*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList();
        
        // We move our pivot element nums[i] and analyze elements to its right
        // Since the array is sorted, we only need to consider the negative as pivots
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            
            // Skip if we found duplicates
            if (i == 0 || nums[i - 1] != nums[i]) {
                
                // perform two sum for each non-repeated pivot
                twoSum(nums, i, output);
            }
        return output;
    }
    
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        
        // HashSet to contains all numbers we have seen 
        var seen = new HashSet<Integer>();
        
        // iterate through the right of the pivot
        for (int j = i + 1; j < nums.length; ++j) {
            
            // in order for nums[i] + nums[j] + complement = 0
            int complement = -nums[i] - nums[j];
            
            // if triplet is found
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                
                // skip all duplicated nums
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            
            // add the current element to the HashSet
            seen.add(nums[j]);
        }
    }
}
        
     
