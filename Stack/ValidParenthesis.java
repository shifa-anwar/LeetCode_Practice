/*
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean flag=false;
        if(s.length()==1)
         return false;   
        for(int i=0;i<s.length();i++)
        {  
         char c = s.charAt(i);   
         if(c=='('||c=='['||c=='{')   
          stack.push(c);
           if(stack.isEmpty())
            return false;
            char ch;
            switch(c)
            {
            case ']':
            ch = stack.pop();
            if(ch=='{'||ch=='(')  
            return false;
            break;     
            case '}':
            ch=stack.pop();
            if(ch=='('||ch=='[')
            return false;
            break; 
            case ')':    
            ch=stack.pop();
            if(ch=='{'||ch=='[')
            return false;
             break;       
              }
           }     
        return stack.isEmpty();
    }
}