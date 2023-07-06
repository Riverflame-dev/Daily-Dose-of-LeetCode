/*
Algorithm:
- Use a size 26 int arrays as buckets for each letter in alphabet. 
- Increments the bucket value with String s and decrement with string t. 
- If they are anagrams, all buckets should remain with initial value which is zero. 
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        // Edge case when the length doesn't match
        if(s.length() != t.length()) 
            return false;

        // Frequency table for each alphabet
        int[] alphabet = new int[26];

        // Store the frequency of every char in s
        for (int i = 0; i < s.length(); i++) 
            alphabet[s.charAt(i) - 'a']++;
        
        // Check if the frequencies for every char in s matches with t
        // whenever we meet a character that also in the first string, substract its count by 1. 
        // If we met a character that is not in the first string, 
        // or the count of this character in the second string already exceeds its count in the first one, 
        // simply return false 
        for (int i = 0; i < t.length(); i++) 
            if (alphabet[t.charAt(i) - 'a']-- == 0) return false;
        return true;
    }   
}


// Or just do the frequency update in one go
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        
        for(int test:arr)
            if(test!=0) return false;
        return true;
    }
}
