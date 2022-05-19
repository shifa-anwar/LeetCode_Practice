/*
Letter combination of a phone number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            return new ArrayList<String>();
        }
        return letter(digits);
    }
    
static String code[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letter(String str)
    {
        if(str.length()==0)
        {
         List<String> li = new ArrayList<>();
         li.add("");
         return li;   
        }
        char ch = str.charAt(0);
        List<String> crs = letter(str.substring(1));
        List<String> rrs = new ArrayList<>();
       String chcode= code[ch-'0'];
        for(int i =0;i<chcode.length();i++)
        {
         char c = chcode.charAt(i);
         for(String res:crs)
         {
          rrs.add(c+res);   
         }
        }
        return rrs;
    }
}
/*
Time Complexity :
O(n)
This time complexity is linear because a recursion call is made along with using "for loop".

SPACE COMPLEXITY :
O(1)
As no extra space is required, therefore space complexity is constant. However, if we include the space used in the recursive stack then the space complexity is O(n).
*/