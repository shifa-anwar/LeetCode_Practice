class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        if(i>=j)
         return;   
        while(i<j)
        {
         s[i]^=s[j];
         s[j]^=s[i];
         s[i]^=s[j];
            i++;
            j--;
        }
    }
}