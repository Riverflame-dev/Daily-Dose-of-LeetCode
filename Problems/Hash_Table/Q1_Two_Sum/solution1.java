/*
Time Complexity
The total iterations would be - [(n - 1) + (n - 2) + (n - 3) + ... + 2 + 1]
n * (n - 1) / 2 = n^2 - 2n ≈ n^2
Hence, O(n^2)

Space Complexity
Since we are not using any extra data structure hence our space complexity would be O(1)
*/

class Solution {
   public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return new int[0];
    }
}
