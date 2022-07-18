/*
Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
1.Using heap(priority Queue) and hashmap
class Solution {
  static class Pair implements Comparable< Pair> {
   int val,freq;
    Pair(int val,int freq) {
      this.val = val;
      this.freq = freq;
    }
    public int compareTo(Pair o) {
      return this.freq - o.freq;
    }
  }
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
         int count = map.getOrDefault(nums[i],0);
         map.put(nums[i],count+1);   
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
        pq.add(new Pair(m.getKey(),m.getValue()));
        if(pq.size()>k)
        pq.remove();
        }
        int store[] = new int[k];
        for(int i=0;i<k;i++)
        {
         Pair p = pq.remove();   
        store[i]=p.val;
        }
        return store;
       }  
    }
/*
Complexity Analysis

Time complexity : O(N log k)O(Nlogk) if k < Nk<N and \mathcal{O}(N)O(N) in the particular case of N = kN=k. That ensures time complexity to be better than \mathcal{O}(N \log N)O(NlogN).

Space complexity : O(N + k)O(N+k) to store the hash map with not more NN elements and a heap with kk elements.
*/

2. using quickselect
class Solution {
    int unique[];
    HashMap<Integer,Integer> count;
    public void swap(int a ,int b)
    {
      int temp = unique[a];
      unique[a]=unique[b];
      unique[b]=temp;
    }
    public int partition(int left,int right,int pvt_index)
    {
        int pvt_freq = count.get(unique[pvt_index]);
        swap(pvt_index,right);
        int store=left;
        for(int i=left;i<=right;i++)
        {
         if(count.get(unique[i])<pvt_freq)
         {
           swap(store,i);
           store++;  
         }        
        }
        swap(store,right);
        return store;
    }
    public void quickselect(int left,int right,int ksmall)
    {
        if(left==right)
           return; 
        Random rand = new Random();
        int pvt_index=left+rand.nextInt(right-left);
        pvt_index=partition(left,right,pvt_index);
        if(ksmall==pvt_index)
        {
          return;  
        }
        else if(ksmall<pvt_index)
        {
          quickselect(left,pvt_index-1,ksmall);  
        }
        else
        {
            quickselect(pvt_index+1,right,ksmall);   
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
       count = new HashMap();
        for(int n:nums)
        {
        count.put(n,count.getOrDefault(n,0)+1);    
        }
        int n = count.size();
        unique=new int[n];
        int i=0;
        for(int num:count.keySet())
        {
         unique[i]=num;
         i++;   
        }
        quickselect(0,n-1,n-k);
        return Arrays.copyOfRange(unique,n-k,n);
    }
}
/*
Time complexity: \mathcal{O}(N)O(N) in the average case, \mathcal{O}(N^2)O(N 
2
 ) in the worst case. Please refer to this card for the good detailed explanation of Master Theorem. Master Theorem helps to get an average complexity by writing the algorithm cost as T(N) = a T(N / b) + f(N)T(N)=aT(N/b)+f(N). Here we have an example of Master Theorem case III: T(N) = T \left(\frac{N}{2}\right) + NT(N)=T( 
2
N
​
 )+N, that results in \mathcal{O}(N)O(N) time complexity. That's the case of random pivots.

In the worst-case of constantly bad chosen pivots, the problem is not divided by half at each step, it becomes just one element less, that leads to \mathcal{O}(N^2)O(N 
2
 ) time complexity. It happens, for example, if at each step you choose the pivot not randomly, but take the rightmost element. For the random pivot choice the probability of having such a worst-case is negligibly small.

Space complexity: up to \mathcal{O}(N)O(N) to store hash map and array of unique elements.
*/