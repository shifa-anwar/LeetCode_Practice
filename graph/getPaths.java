/*
All Paths From Source to Target
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) { 
      List<List<Integer>> path = new ArrayList<>();   
     ArrayList<Integer> li = new ArrayList<>();      
    boolean visited[] = new boolean[graph.length];    
    findPath(graph,0,visited,path,li);
    return path;    
    }
    public void findPath(int[][] graph,int src,boolean visited[],List<List<Integer>> path,ArrayList<Integer> li )
    { 
     li.add(src);   
     if(src==graph.length-1)
     {
       path.add(new ArrayList(li));  
         return;
     }
     visited[src]=true;
     for(int j=0;j<graph[src].length;j++)
     {
      int val = graph[src][j];
      if(!visited[val])
      {
         findPath(graph,val,visited,path,li);
         li.remove(li.size()-1);
      }
     }
        visited[src]=false;
    }
}
