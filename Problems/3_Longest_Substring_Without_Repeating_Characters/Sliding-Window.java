/*
This approach 

- uses the distance between the last repeated char and the current char (current iteration) to calculate the length of the current unique substring
- uses an int[] as a char map for all encountered char and Math.max() to determine if a char is repeated
- uses Math.max() to determine the longest length encountered in each iteration
- accomplishes everything in one loop
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, longest = 0;
        int[] chars = new int[95];
        int offset = 32;

        while (r < s.length()) {

	    // Update l with index+1 of the last repeated char
            int c = s.charAt(r);
            l = Math.max(chars[c - offset], l);

	    // r - l + 1 : calculate length of the current unique substring
	    // Update the longest value
            longest = Math.max(longest, r - l + 1);

	    // Update chars[] with the index+1 for all encountered chars
            chars[c - offset] = r + 1;

	    // Move pointer to next char
            r++;
        }

        return longest;
    }
}
