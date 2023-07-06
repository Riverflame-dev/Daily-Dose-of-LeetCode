/*
This approach has a time complexity of O(n log n) due to the sorting operation, where n is the length of the strings.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
