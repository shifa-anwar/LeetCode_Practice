class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list= new ArrayList<>();
        int nge[]= new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length-1);
        nge[nums.length-1]=nums.length;//first find next greater element index of each element
        for(int i=nums.length-2;i>=0;i--)
        {
         while(!stack.isEmpty()&&nums[i]>=nums[stack.peek()])
         {
          stack.pop();
         }
            if(stack.size()==0)
             nge[i]=nums.length;
            else
             nge[i]=stack.peek();   
            stack.push(i);
        }
        int j=0;
        for(int i=0;i<=nums.length-k;i++)
        {
            if(j<i)
            {
              j=i;  
            }
            while(nge[j]<i+k)//if next greater is outside the window then the current element is maximum else jump to next greater element
            {
                j=nge[j];
            }
            list.add(nums[j]);
        }
        int arr[]= new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
         arr[i]=list.get(i);   
        }
        return arr;
    }
}
