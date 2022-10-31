/*
Time complexity: O(n^2)
Space complexity: O(1)
*/

public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        
        // left boundary of the container
        for (int left = 0; left < height.length; left++) {
            
            // right boundary of the container
            for (int right = left + 1; right < height.length; right++) {
                
                // width is the difference between left and right index
                int width = right - left;
                
                // the lower height between height[left] and height[right]
                // determines the max area
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }
}
