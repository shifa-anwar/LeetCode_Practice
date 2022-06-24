/*
Excel Sheet Column Title
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1
*/
1. class Solution {
    public String convertToTitle(int columnNumber) {
       int rem=0,num=columnNumber; 
       String str=""; 
     while(num!=0)
     {
      if(num%26==0)
       {
        rem=26;
        num = (num/26)-1;  
        str=convertToChar(rem)+str;   
       }
       else
       { 
       rem=num%26;
      num/=26;      
      str=convertToChar(rem)+str; 
       }   
     }
     return str;   
     }
    public char convertToChar(int num)
    {  
    char res =(char)(num+'A'-1);    
      return res; 
    }
}

2.using string builder
class Solution {
    public String convertToTitle(int columnNumber) {
       StringBuilder sb = new StringBuilder(""); 
     while(columnNumber!=0)
     {
     int rem = columnNumber%26;
      char str = (char)((rem==0?26:rem)+64);
      sb.append(str);
      int divisor =columnNumber/26; 
      columnNumber=(rem==0?divisor-1:divisor);  
    }
      return sb.reverse().toString();  
}
}