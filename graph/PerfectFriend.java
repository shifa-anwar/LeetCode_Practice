/*
Perfect Friends
1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
Sample Input
7
5
0 1
2 3
4 5
5 6
4 6
Sample Output
16
*/
import java.io.*;
import java.util.*;

class Main
{
static class Edge
{
int v,n;
Edge(int v,int n)
{
this.v = v;
this.n = n;
}
}
public static void main(String args[])throws Exception
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
int k = Integer.parseInt(br.readLine());
ArrayList<Edge> graphs[] = new ArrayList[n];
for(int v=0;v<n;v++)
{
graphs[v]=new ArrayList<>();
}
for(int e=0;e<k;e++)
{
String line = br.readLine();
String parts[]=line.split(" ");
int v1 = Integer.parseInt(parts[0]);
int v2 = Integer.parseInt(parts[1]);
graphs[v1].add(new Edge(v1,v2));
graphs[v2].add(new Edge(v2,v1));
}
boolean visit[] = new boolean[n];
ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
for(int v=0;v<n;v++)
{
if(!visit[v])
{
ArrayList<Integer> comp = new ArrayList<>();
drawTree(graphs,v,comp,visit);
comps.add(comp);
}
}
int count=0;
for(int i=0;i<comps.size();i++)
{
for(int j=i+1;j<comps.size();j++)
{
count+=comps.get(i).size()*comps.get(j).size();   
}
}
System.out.println(count);
}
//end of main
public static void drawTree(ArrayList<Edge> graphs[],int src,ArrayList<Integer> comp,boolean visit[])
{
visit[src]=true;
comp.add(src);
for(Edge e:graphs[src])
{
if(!visit[e.n])
{
drawTree(graphs,e.n,comp,visit);
}
}
} 
}