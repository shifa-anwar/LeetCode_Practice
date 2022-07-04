/*
Camelcase Matching
Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.

Example 1:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
*/
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
     ArrayList<Boolean> list = new ArrayList<>();   
     for(String s:queries)
     {
      int idx=0,i=0;   
      for(i=0;i<s.length();i++)
      {
       char ch = s.charAt(i);   
       if(idx>=pattern.length()&&ch>='A'&&ch<='Z')
           break;
        if(idx<pattern.length()&&ch==pattern.charAt(idx))
           idx++;
        else if(ch>='A'&&ch<='Z'&&ch!=pattern.charAt(idx))
           break; 
      }
        if(idx==pattern.length()&&i==s.length())
          list.add(true);
         else
          list.add(false);   
     }
      return list;  
    }
}
Time:O(n2)
Space:O(n)    