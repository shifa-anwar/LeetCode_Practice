/*
Ksorted array
*/
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> li = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<=k;i++)
        {
        pq.add(arr[i]);    
        }
        for(int i=k+1;i<arr.length;i++)
        {
        li.add(pq.remove());
        pq.add(arr[i]);
        }
        while(pq.size()>0)
        {
        li.add(pq.remove());    
        }
        return li;
    }
}
