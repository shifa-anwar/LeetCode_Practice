/*
1207. Unique Number of Occurrences
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        HashSet<Integer> set= new HashSet<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            int count=map.getOrDefault(arr[i],0);
          if(!map.containsKey(arr[i]))
              map.put(arr[i],1);
            else
            map.put(arr[i],count+1);
        }    
     for (Map.Entry<Integer,Integer> pair : map.entrySet())
     {
        set.add(pair.getValue());
     }
        return (map.size()==set.size());
    }
}