/*
Approach 3: Improve With Binary Search
- In the previous approach, when we have an element num that is not greater than all the elements in sub, we perform a linear scan to find the first element in sub that is greater than or equal to num. 
- Since sub is in sorted order, we can use binary search instead to greatly improve the efficiency of our algorithm.

Time complexity: O(N⋅log(N))
- Binary search uses log⁡(N)\log(N)log(N) time as opposed to the O(N) time of a linear scan, which improves our time complexity from O(N^2) to O(N⋅log(N)).

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
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);

            // if num is not greater than the last element in the subsequence 
            // Find the first element in the subsequence that is greater than or equal to num
            // Since sub is in sorted order, use binary search instead to greatly improve the efficiency 
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
