// Explained: https://www.youtube.com/watch?v=NiUsnWNwixk
// Approach:
// - We will use a Hash map and store the count of remainders in the Map.
// - Iterate throught the list and calculate the sum till each value.
// - find the remainder of the sum at each index and store it in the map
// - if that remainder already exist in the map, this means the sum of the sum array from that idx to current index is divisible by k.
// - So add the count present for that remainder to the final count and increment the value in map
// - return the final count.

class Solution {
    public int subarraysDivByK(int[] nums, int K) {
        // Edge cases
        if(nums == null || nums.length == 0) return 0;
        
        int ans = 0;
        int remSum = 0;
        
        // HashMap will store the frequency of each remainder we get by doing remSum % k
        HashMap<Integer, Integer> map = new HashMap<>();
        // When remSum % k = 0, we know for sure the current remSum is devisible by k
        // hence freq of 0 as remainder should begin with 1
        map.put(0, 1);           
        
        for(int i = 0; i < nums.length; i++){
            
            // Get the sum of all element until the current index
            remSum += nums[i];
            
            // Get the remainder 
            int temp = remSum % K;
            
            // Keep the remainder positive
            if(temp < 0) temp += K;
            
            // If the remainder has occurred, there must be divisible subarray inbetween 
            // the current index and the index when the remainder last occurred
            if(map.containsKey(temp)){
                
                // We increment the count by adding the frequency of the occurence of this remainder
                // which will account for the different combinations of the subarray till this point
                ans += map.get(temp);
            }
            
            // Update the frequency map for remainders
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return ans;
    }
}   
