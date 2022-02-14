class Solution {
    public String interpret(String command) {
    char arr[]= command.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<arr.length;i++)
    {
       if(arr[i]=='G')
       {   
       sb.append('G');
       }
        if(arr[i]=='(')
        {
          if(arr[i+1]==')')
          {sb.append('o');}
           if(arr[i+1]=='a')
           {
               sb.append('a');
               sb.append('l');
           }
         }
    }
        return sb.toString();
}
}