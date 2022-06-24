/*
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" "))
            return 1;
         if(s.length()==0||s.length()==1)
           return s.length();
        int max=Integer.MIN_VALUE,length=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {  
          if(map.containsKey(s.charAt(i)))
          { 
            j=Math.max(map.get(s.charAt(i)),j); //get the max of index of last repeating character or current repeating character(dry run for "abba")
          }
           map.put(s.charAt(i),i+1);//will store one index ahead so that substring will get from next character
           length = i-j+1;//difference between the characters
            max = Math.max(length,max);
        }
        return max;
    }
}