/*
Same Time complexity: O(n)
Improved space complexity to O(1)
- Only one int veriable right is using extra space
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // right contains the product of all the elements to the right at each index
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so right would be initialized to 1
        int right = 1;
        
        // For the last element, product except self would be L[length - 1]*1
        answer[length - 1] = L[length - 1] * right;
        
        // Get the product of all elements to the right of index 'i'
        // and constructing the answer array
        for (int i = length - 2; i >= 0; i--) {
            
            // right already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            right = nums[i + 1] * right;
            
            // Multiple product of all elements to the left and to the right
            // and update the answer array
            answer[i] = L[i] * right;
        }
        return answer;
    }
}
