/*
Max Product of two elements
*/
1.Brute Force
class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
             int pro=(nums[i]-1)*(nums[j]-1);
                if(pro>max)
                    max=pro;
            }
        }
        return max;
    }
}
Time:O(n2)
Space:O(1)
2.Priority Queue
class Solution {
    public int maxProduct(int[] nums) {
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     for(int i=0;i<nums.length;i++)
     {
       if(i<2)  
       pq.add(nums[i]);
      else
      {
       if(pq.peek()<nums[i])
       {
         pq.remove();
         pq.add(nums[i]);  
       }
      }
    }
      int pro=1;  
     while(pq.size()>0)
     {
       pro *= pq.peek()-1;  
       pq.remove();  
     }
        return pro;
}
}
Time - O(nlogn)
space-O(n)
3.largest and second largest
class Solution {
    public int maxProduct(int[] nums) {
       int largest=0,second_largest=0;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]>largest)
           {
               second_largest=largest;
               largest=nums[i];
           }
            else if(nums[i]>second_largest)
            {
                second_largest=nums[i];
            }
        }
        return (largest-1)*(second_largest-1);
    }
}
Time - O(n)
Space-O(1)
