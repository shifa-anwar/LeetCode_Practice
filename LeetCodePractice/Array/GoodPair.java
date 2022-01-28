//Number of Good Pairs
1.Using hashing
class GoodPair {
    public int numIdenticalPairs(int[] nums) {
     int max = nums[0],good=0;
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]>max)
            max = nums[i];
       }
        int hash[]= new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            hash[nums[i]]++;
        }
        for(int j=0;j<hash.length;j++)
        {
            good+=(hash[j]*(hash[j]-1))/2;
        }
        return good;
}
}

2.By comparing each number in loops
class Solution {
    public int numIdenticalPairs(int[] nums) {
      int good=0;  
     for(int i=0;i<nums.length;i++)
     {
      for(int j=i+1;j<nums.length;j++)
      {
       if(nums[i]==nums[j]&&i<j)
           good++;
      }   
     }
        return good;
    }
}