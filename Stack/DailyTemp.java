class Solution {
    public int[] dailyTemperatures(int[] arr) {
    int nums[] = new int[arr.length];
    for(int i=0;i<nums.length-1;i++)
    {
    for(int j=i+1;j<nums.length;j++)
    {
     if(arr[j]>arr[i])
     {
       nums[i]=j-i;
         break;
     }
    }
    }
     return nums;   
    }
}
Time Complexity:O(n2)
Space Complexity:O(n)    

2. using stack
class Solution {
    public int[] dailyTemperatures(int[] arr) {
    Stack<Integer> st = new Stack<>();
    st.push(0);    
    for(int i=1;i<arr.length;i++)
    {
     while(!st.isEmpty()&&arr[st.peek()]<arr[i])
     {
      int x = st.pop();   
      arr[x]=i-x;   
     }
     st.push(i);
    }
     while(!st.isEmpty())
     {
      arr[st.pop()]=0;   
     }
     return arr;   
    }
}
time:O(n)
space:O(n)