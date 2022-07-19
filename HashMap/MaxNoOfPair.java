/*
Maximum Number of Pairs in Array
*/
class Solution {
    public int[] numberOfPairs(int[] nums) {
     HashMap<Integer,Integer> map = new HashMap<>();
       int pair=0,left=0;
     for(int i=0;i<nums.length;i++)
     {
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);   
     }
     for(Map.Entry<Integer,Integer> entry:map.entrySet())
     {
       pair+=entry.getValue()/2;
       left+=entry.getValue()%2;  
     }
     int arr[]= new int[2];
      arr[0]=pair;
      arr[1]=left;
      return arr;  
    }
}
Time:O(n)
Spac:O(n)