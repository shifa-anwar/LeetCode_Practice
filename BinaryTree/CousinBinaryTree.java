/*
Cousins in Binary Tree
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
*/       

1.using dfs
class Solution {
    int xHeight,yHeight;
    TreeNode xParent,yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null);
         if(xHeight==yHeight&&xParent!=yParent)
         {
           return true;  
         }
        else
        {
           return false; 
        }
    }
    public void helper(TreeNode root,int x,int y,int height,TreeNode prev)
    {
     if(root==null)
     {
        return; 
     }
     if(root.val==x)
     {
       xHeight=height;
       xParent=prev;    
     }
     if(root.val==y)
     {
        yHeight=height;
        yParent=prev; 
     }
     prev = root;
     helper(root.left,x,y,height+1,prev);
     helper(root.right,x,y,height+1,prev);   
    }
}
Time:O(n)
space:O(n)
2.using bfs
class Solution {
static class Pair
{
  int level; 
  TreeNode node;
    int parent;  
  Pair(TreeNode node,int parent,int level)
  {
   this.node = node;
   this.parent=parent;   
   this.level=level;   
  }
}
    public boolean isCousins(TreeNode root, int x, int y) { 
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root,-1,0));
    while(q.size()>0)
    {
     int c1=-1,c2=-1,p1=-1,p2=-1;   
     int c = q.size();
     for(int i=0;i<c;i++)
     {
     Pair rem = q.remove();
     if(rem.node.val==x)
     {
      c1=rem.level;
      p1 =rem.parent;   
     }
     if(rem.node.val==y)
     {
      c2=rem.level;
      p2 =rem.parent;   
     }
     if(c1==c2&&p1!=p2)
     {
      return true;   
     }
     if(rem.node.left!=null)
     {
        q.add(new Pair(rem.node.left,rem.node.val,rem.level+1)); 
     }
     if(rem.node.right!=null)
      {
        q.add(new Pair(rem.node.right,rem.node.val,rem.level+1));    
      }
    }
    }
     return false;    
    }
}
Time:O(n)
space:O(n)