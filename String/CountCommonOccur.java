/*
2085. Count Common Words With One Occurrence
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.
Example 1:
Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.

Example 2:
Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.

Example 3:
Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
*/
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer>map= new HashMap<String,Integer>();
        int count=0;
        for(int i=0;i<words1.length;i++)
        {
          if(map.containsKey(words1[i]))
              map.put(words1[i],2);
            else
                map.put(words1[i],-1);
        }
        for(int j=0;j<words2.length;j++)
        {
            if(map.containsKey(words2[j]))
            {
               map.put(words2[j],map.get(words2[j])+1);
            }
            else
            {
                map.put(words2[j],1);
            }
            
        } 
        
 for(Map.Entry<String,Integer> hm:map.entrySet())
       {
           if(hm.getValue()==0)
                count++;
        }
        return count;
    }
}