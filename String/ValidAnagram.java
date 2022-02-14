class Solution {
    public boolean isAnagram(String s, String t) {
        int hash1[]=new int[128];
        int hash2[]=new int[128];
    for(int i=0;i<s.length();i++)
    {
        hash1[s.charAt(i)]++;
    }
    for(int i=0;i<t.length();i++)
    {
        hash2[t.charAt(i)]++;
    }
    for(int i=0;i<128;i++)
    {
        if(hash1[i]!=hash2[i])
         return false;
    }
    return true;
}
}