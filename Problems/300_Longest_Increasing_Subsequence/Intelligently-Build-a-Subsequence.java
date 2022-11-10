/*
Approach 2: Intelligently Build a Subsequence
- the difficult part of this problem is deciding if an element is worth using or not.
- this algorithm does not always generate a valid subsequence of the input, but the length of the subsequence will always equal the length of the longest increasing subsequence.
- The length remains correct because the length only changes when a new element is larger than any element in the subsequence. In that case, the element is appended to the subsequence instead of replacing an existing element.

Time complexity: O(N^2)
- This algorithm will have a runtime of O(N^2) only in the worst case. 
- Despite having the same time complexity as the previous approach, in the best and average cases, it is much more efficient.

Space complexity: O(N)
- When the input is strictly increasing, the sub array will be the same size as the input.

*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        // an ArrayList to store the subsequence
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            // if num is greater than the last element in the subsequence 
            // num can be appended to the existing subsequence
            if (num > sub.get(sub.size() - 1)) sub.add(num);
      
            else {
                // if num is not greater than the last element in the subsequence 
                // Find the first element in the subsequence that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) j += 1;
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
}
