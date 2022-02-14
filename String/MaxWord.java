class Solution {
    public int mostWordsFound(String[] sentences) {
       int max=0;
        for(String s:sentences)
        {
          char []arr = s.toCharArray();  
           int c=0;
            for(int i=0;i<arr.length;i++)
            {
              if(arr[i]==' ')
              {  
                  c++;
              }
            } 
            if(c>max)
                max=c;
        }
        return max+1;
    }
}