/*
Remove Outermost Parentheses
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
*/

1.using stack
/*
|          |
|          |
|          | 
|    (     |
|____(_____|
 after these two opening braclet when we will recieve closing bracket )
 then pop from stack
 */
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int open=0;
        String res="";
        for(int i=0;i<s.length();i++)
        {
        if(s.charAt(i)=='(')
         stack.push(i);   
        else
        {
            int p = stack.pop();
            if(stack.isEmpty())
            {
                res+=s.substring(p+1,i);
            }
        }
        }
        return res;
    }
}

2.without stack
/*
ex- (()())(())
bracket with x will not be added
increase the count when recieve ( bracket and decrease it when recieve ) bracket
count 
1     (  x
2     (
1     )
2     (
1     )
0     )  x
1     (  x
2     (
1     )
0     )  x
*/
class Solution {
    public String removeOuterParentheses(String s) {
        int open=0;
        String res="";
        for(int i=0;i<s.length();i++)
        {
        if(s.charAt(i)=='(')
        {
         open++;
         if(open>1)
         res+=s.charAt(i);   
        } 
        else
        {
        open--;
        if(open>0)
        res+=s.charAt(i); 
        }
        }
        return res;
    }
}
