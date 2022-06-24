/*
Reverse word in string
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
*/
class Solution {
    public String reverseWords(String s) { 
       s = s.trim();//remove trailing spaces
        String res="";
       for(int i=0;i<s.length();i++) //remove in between space
       {
        if(s.charAt(i)==' '&&s.charAt(i+1)==' ')
        {
           continue; 
        }
           else
           {
            res+=s.charAt(i);   
           }
       }
        String arr[] = res.split(" ");
        res="";
        for(int i= arr.length-1;i>0;i--)//reverse the string
        {
          res+=arr[i]+" ";  
        }
        res+=arr[0];
        return res;
    }
}

2.
  public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i>=0; i--) {
            if (!words[i].isEmpty())
                sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }