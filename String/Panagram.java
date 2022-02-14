class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26)
        return false;
        char[] arr = sentence.toCharArray();
      int hash[]= new int[26];
        for(int i=0;i<arr.length;i++)
        {
            hash[arr[i]-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(hash[i]==0)
            {   
                return false;
            }
        }
        return true;
    }
}