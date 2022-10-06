/*
This approach
- uses a left pointer for the first char of a substring
- uses a right pointer for the last char of a substring, and it slides to the end of the string
- when the right pointer points to a repeated char, the left pointer moves forward until the repeated char is dropped 
- when the right pointer points to a non-repeated char, the max length is increased by one
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Sliding window pointers
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        
        // Hashset will contain every unique substring encountered
        HashSet<Character> hash_set = new HashSet();
        
        while (b_pointer < s.length()) {
            
            // Encounter new char
            if (!hash_set.contains(s.charAt(b_pointer))) {
                
                // Add new char to the hashset and move right pointer forward
                hash_set.add(s.charAt(b_pointer));
                b_pointer++;
                
                // Update the max length
                // By comparing the hash set size and the current max value
                max = Math.max(hash_set.size(), max);
                    
            // Encounter repeated char
            }else {
                
                // Remove left most char from the hashset and move left pointer forward
                // Right pointer is still pointing at this repeated char 
                // Hence if the new left most char is still repeated, it will be removed again
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        
        return max;
    }
}
