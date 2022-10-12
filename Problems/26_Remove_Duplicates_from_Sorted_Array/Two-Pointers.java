/*
Algorithm:
First Index is responsible for writing unique values in our input array, while Second Index will read the input array and pass all the distinct elements to First Index.

Time Complexity: O(n) 
- since we only have 2 pointers, and both the pointers will traverse the array at most once.

Space Complexity: O(1)
- since we are not using any extra space.
*/


class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Left pointer stay at the location where we want to insert the next unique int
        // nums[1] is where we should start with because nums[0] is the only unique int we do not need to move 
        int insertIndex = 1;
        
        // Right pointer all visit every element until the end of array
        for(int i = 1; i < nums.length; i++){
            
            // Move left pointer ONLY at the first encounter of a new element
            // We skip all the duplicates of this element until encounter a new elemnt
            if(nums[i - 1] != nums[i]) {
                
                // Upon the first encounter of a new element,
                // store it at left pointer and incrementing left pointer to the next slot 
                nums[insertIndex] = nums[i];     
                insertIndex++;
            }
        }
        
        // After reaching the end of the array,
        // the left pointer will hold the count of unique elements in the input array.
        return insertIndex;
    }
}
