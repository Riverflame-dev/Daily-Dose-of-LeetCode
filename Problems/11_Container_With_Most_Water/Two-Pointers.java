/*
Two Pointer Approach
- We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. 
- Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now. 
- At every step, we find out the area formed between them, update maxarea and move the pointer pointing to the shorter line towards the other end by one step.

Time complexity: O(n). Single pass.
Space complexity: O(1). Constant space is used.
*/

public class Solution {
    public int maxArea(int[] height) {
        
        int maxarea = 0;
        int left = 0; 
        int right = height.length - 1;
        
        // As long as two pointers have not met
        while (left < right) {
            
            // width is the difference between left and right index
            int width = right - left;

            // the lower height between height[left] and height[right]
            // determines the max area
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            
            // move the pointer at the lower boundry 
            if (height[left] < height[right]) left++;
            else right--;

        }
        return maxarea;
    }
}
