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