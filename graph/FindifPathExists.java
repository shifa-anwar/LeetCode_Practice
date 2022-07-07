/*
Find if Path Exists in Graph
*/
class Solution {
    class Edge
    {
     int src,nbr;
     Edge(int src,int nbr)
     {
      this.src=src;
      this.nbr=nbr;   
     }    
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     boolean visit[]=new boolean[n];
        ArrayList<Edge>[] path = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
         path[i]=new ArrayList<>(); 
        }
        for(int[]edge:edges)
        {
         path[edge[0]].add(new Edge(edge[0],edge[1]));
         path[edge[1]].add(new Edge(edge[1],edge[0]));   
        }
        return hasPath(path,source,destination,visit);
    }
    public boolean hasPath(ArrayList<Edge>[]path,int src,int des,boolean visited[])
    {
      if(src==des)
      return true;
      visited[src]=true;
      for(Edge e:path[src])
      {
       if(!visited[e.nbr])
       {
        if(hasPath(path,e.nbr,des,visited))
           return true; 
       }
      }
        return false;
    }
}