class Solution {
    public List<String> buildArray(int[] target, int n) {
       int i=1,index=0;
        ArrayList<String> li = new ArrayList<String>(); 
        while(index<target.length)
        {
            if(i==target[index])
            {
                li.add("Push");
                index++;
            }
            else
            {
               li.add("Push"); 
               li.add("Pop"); 
            }
            i++;
        }
        return li;
    }
}