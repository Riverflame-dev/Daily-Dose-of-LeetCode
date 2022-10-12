/*
Calculate the difference of target (c) and the current element (a) and find the other element (b)

Time Complexity
Since we are iterating the array only once, the time complexity would be O(n).

Space Complexity
Since we need a Map of the size of the array, the space complexity would be O(n).
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
    
        for (int i = 0; i < nums.length; ++i)
        {
            if (table.containsKey(target - nums[i]))
            {
                int rs = table.get(target - nums[i]); 
                return new int[]{i, rs};
            }
            else table.put(nums[i], i);
        }
        
        return null;
    }
}
