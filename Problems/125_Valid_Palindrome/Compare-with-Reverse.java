/*
Approach 1: Compare with Reverse

Time complexity : O(n)
- We need to iterate thrice through the string:
- 1) When we filter and convert to lower-case.
- 2) When we reverse the string.
- 3) When we compare the original and the reversed strings.
- Each iteration runs linear in time (since each character operation completes in constant time). Thus, the effective run-time complexity is linear.

Space complexity : O(n)
- We need O(n) additional space to stored the filtered string and the reversed string.
*/

class Solution {
  public boolean isPalindrome(String s) {

    // Create a string with string builder
    StringBuilder builder = new StringBuilder();

    // Filter out all other types of characters
    // convert the remaining letters to lower case. 
    for (char ch : s.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        builder.append(Character.toLowerCase(ch));
      }
    }

    // Use toString() method and .reverse() method to get the
    // original char sequence and the reversed one
    String filteredString = builder.toString();
    String reversedString = builder.reverse().toString();

    // A palindrome and its reverse are identical to each other
    return filteredString.equals(reversedString);
  }
