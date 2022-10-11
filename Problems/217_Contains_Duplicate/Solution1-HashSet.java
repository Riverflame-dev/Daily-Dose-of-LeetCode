/*Time: O(n)
Space: O(n)*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // Hashset will contain every unique element encountered
        Set<Integer> seen = new HashSet<>();
        
        for (int num: nums) {
            // Repeated element cannot be added to Hashset
            if (!seen.add(num)) {
              return true;
            }
        }
        return false;
    }
}
