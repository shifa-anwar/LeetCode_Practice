class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> s1 = new HashSet<Integer>();
      HashSet<Integer> s2 = new HashSet<Integer>();  
        int k=0;
      for(int i=0;i<nums1.length;i++)
      {
         s1.add(nums1[i]); 
      }
        for(int j=0;j<nums2.length;j++)
        {
            if(s1.contains(nums2[j]))
                s2.add(nums2[j]);
        }    
        int arr[] = new int[s2.size()];
        for(int s:s2)
        {
            arr[k++]=s;
        }
        return arr;
        
    }
}