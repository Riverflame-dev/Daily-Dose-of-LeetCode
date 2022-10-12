/*
Use the ideal data structure to solve string problem.
*/

class Solution {
    public boolean isValid(String s) {
        
        // Optimization for edge cases: 
        // Length of s is odd number or s is empty
        if(s.length() % 2 != 0 || s.isEmpty())return false;
        
        // Last-In-First-Out data structure is ideal because:
        // The stack will store open brackets in the order as visited
        // Close brackets must appear in the exact reversed order to be valid parentheses
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            
            // Push only open bracket to the stack
            if(a == '(' || a == '[' || a == '{') stack.push(a);
            
            // When we see a close bracket without seeing an open bracket first,
            // it's not a valid parentheses
            else if(stack.empty()) return false;
            
            // When the close bracket doesn't match the type of the last visited open bracket,
            // it's not a valid parentheses
            else if(a == ')' && stack.pop() != '(') return false;
            else if(a == ']' && stack.pop() != '[') return false;
            else if(a == '}' && stack.pop() != '{') return false;
        }
        
        // If all open brackets pushed to the stack is poped
        // it means that we have visited the corresponding close brackets in the correct order. 
        // Hence valid parentheses
        return stack.empty();
    }
}
