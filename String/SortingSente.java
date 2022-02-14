class Solution {
    public String sortSentence(String s) {
    String arr[]= s.split(" ");
     String arr1[]= new String[10];    
        for(String w:arr)
        {
         int n = Integer.parseInt(w.substring(w.length()-1));
         arr1[n]= w.substring(0,w.length()-1);   
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]!=null)
             sb.append(arr1[i]+" ");   
        }
        return sb.toString().trim();
    }
}