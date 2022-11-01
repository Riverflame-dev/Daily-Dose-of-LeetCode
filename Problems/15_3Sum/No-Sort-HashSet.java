/*
Approach 3: "No-Sort"
- We move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the Two Sum: One-pass Hash Table approach, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.
- Use another hashset dups to skip duplicates in the outer loop.
- Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once. Values in the hashmap will indicate whether we have encountered that element in the current iteration.

Time Complexity: O(n^2)
- We have outer and inner loops, each going through nn elements.
- While the asymptotic complexity is the same, this algorithm is noticeably slower than the previous approach.
- Lookups in a hashset, though requiring a constant time, are expensive compared to the direct memory access.

Space Complexity: O(n)
- for the hashset/hashmap.
- For the purpose of complexity analysis, we ignore the memory required for the output. However, in this approach we also store output in the hashset for deduplication. In the worst case, there could be O(n^2).
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // HashSet of int lists to contain results
        Set<List<Integer>> res = new HashSet<>();
        // HashSet of ints to check for duplicates
        Set<Integer> dups = new HashSet<>();
        // HashMap to keep track of the elements we've seen so far
        Map<Integer, Integer> seen = new HashMap<>();
        
        // We move our pivot element nums[i] and check if it's a duplicate
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                
                // if nums[i] is not duplicate, analyze elements to its right
                for (int j = i + 1; j < nums.length; ++j) {
                    
                    // in order for nums[i] + nums[j] + complement = 0
                    int complement = -nums[i] - nums[j];
                    
                    // complement has been seen in the current iteration
                    // triplet is found
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    
                    // set hashmap value to i to indicate which iteration 
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}
