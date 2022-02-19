class Solution {
    public char findTheDifference(String s, String t) {
       char c=0;
        for(int i=0;i<s.length();i++)
        {
           c^=s.charAt(i)^t.charAt(i); 
        }
        c^=t.charAt(t.length()-1);
        return c;
    }
}

/*Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.*/