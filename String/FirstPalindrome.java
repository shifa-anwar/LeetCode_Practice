class Solution {
    public String firstPalindrome(String[] words) {
        for(String s:words)
        {
         if(isPalindrome(s))
         return s;   
        }
      return "";
    }
    public boolean isPalindrome(String words)
    { 
        int i=0,j=words.length()-1;
        while(i<j)
        {
          if(words.charAt(i)!=words.charAt(j))
          {
            return false;  
          }
         i++;
         j--;   
        }
        return true;
    }
}