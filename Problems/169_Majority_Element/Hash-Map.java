/*
Approach 2: HashMap

Time complexity : O(n)
- We iterate over nums once and make a constant time HashMap insertion on each iteration. 

Space complexity : O(n)
- At most, the HashMap can contain n - n/2 associations, so it occupies O(n)O(n) space.

*/


class Solution {
    public int majorityElement(int[] nums) {
        
        // Hash map to store elements and occurrences
        HashMap <Integer, Integer> map = new HashMap<>();
        
        // Iterate through nums[] and update map
        for (int num : nums) {
            
            // If num is in the map, get the current count(key) and increse by 1
            // If num is not in the map, put num in map and assign default value incresed by 1
            map.put(num, map.getOrDefault(num, 0)+1);
            
            // Return num when it's found to be Majority Element
            if (map.get(num) > nums.length / 2) {
                return num;
            }
            
        }

        return 0;
    }
}
