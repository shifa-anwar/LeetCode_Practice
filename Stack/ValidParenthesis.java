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
         if(c=='('||c=='['||c=='{')   //if there are opening bracket then we will push it into stack
          stack.push(c);
         /*what if there was not any opening bracket but a closing bracket comes first then the stack will be empty and it will return false ex-)[]*/
           if(stack.isEmpty())  
            return false;
            char ch;
         /* if any closing bracket comes then we will check the top of stack if it is not the opening part of closing bracket 
         then we will return false
         */
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
     /*
     if it is a valid expression then stack will become empty because each opening will have closing bracket but
     if it is invalid then it will have some bracket left in stack
     */
        return stack.isEmpty();
    }
}
