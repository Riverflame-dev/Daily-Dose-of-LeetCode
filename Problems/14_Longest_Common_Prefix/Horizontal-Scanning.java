/*
Approach 1: Horizontal scanning
- take the first string in the array as the default value for prefix
- iterate through string array, reduce the prefix in each iteration until it exist in the current string at index 0
- If prefix is reduced to empty, there is no common prefix, return ""
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // Edge case:
        // Return empty string when the given array is empty
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        // Initialize prefix with the first string
        String prefix = strs[0];
        
        // Iterate through all strings in the array
        for (int i = 1; i < strs.length; i++)
            
            // Reduce the prefix string one char at a time 
            // untill it exist in the current string at index 0
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix is reduced to empty, there is no common prefix 
                if (prefix.isEmpty()) return "";
            }    
        
        return prefix;
    }
}
