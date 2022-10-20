/*
O(NlogN) time complexity and O(1) space complexity
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        
        // By sorting the array, the kth largest element will all end up at the end of the array 
        for (int i = 1; i <= k; i++) sum += nums[nums.length-i];
        return nums[nums.length-k];
        
    }
}
