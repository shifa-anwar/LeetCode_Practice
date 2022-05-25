/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

Approach:-
Instead of finding every possible string and checking its validity, we can make use of a stack while scanning the given string to:
Check if the string scanned so far is valid.
Find the length of the longest valid string.
In order to do so, we start by pushing -1−1 onto the stack. For every \text{‘(’}‘(’ encountered, we push its index onto the stack.
For every \text{‘)’}‘)’ encountered, we pop the topmost element. Then, the length of the currently encountered valid string of parentheses will be the difference between the current element's index and the top element of the stack.
If, while popping the element, the stack becomes empty, we will push the current element's index onto the stack. In this way, we can continue to calculate the length of the valid substrings and return the length of the longest valid string at the end.
*/
class Solution {
    public int longestValidParentheses(String s) {
        int count =0;
        if(s.length()==0)
        {
           return 0; 
        }
     Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++)
        {
        if(s.charAt(i)=='(')
        {
         st.push(i);   
        }
        else
        {
         st.pop(); 
          if(st.isEmpty())
            st.push(i);
           else
           count = Math.max(count,i-st.peek());       
        }    
        }
        return count;
    }
}
