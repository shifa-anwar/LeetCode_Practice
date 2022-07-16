/*
 N-ary Tree Postorder Traversal
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 

Example 1:


Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Example 2:


Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
 

Follow up: Recursive solution is trivial, could you do it iteratively?

*/
1. using recursion
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null)
        {
           return new ArrayList<>(); 
        }
        for(Node n:root.children)
        {
         postorder(n);   
        }
        list.add(root.val); 
        return list;
    }
}
time:O(n)
Space:O(h)
2.Iterative using stack
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Pair
{
 Node node;
 int state;
 Pair(Node node,int state)
 {
  this.node=node;
  this.state=state;   
 }
}
class Solution {
    public List<Integer> postorder(Node root) {
      ArrayList<Integer> list = new ArrayList<>();
      if(root==null)
      {
          return list;
      }
      Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,-1));
        while(st.size()>0)
        {
         Pair p = st.peek();
         if(p.state==-1)//preorder
         {
          p.state++;   
         }
         else if(p.state==p.node.children.size())
  /*we'll get postorder of a node when it's state is equal to 
its children size 
         {
           list.add(p.node.val);
           st.pop();  
         }
         else
         {
          Pair cp = new Pair(p.node.children.get(p.state),-1); 
          st.push(cp);   
          p.state++;  
         }
        }
        return list;
    }
}
/*
Time Complexity:
O(n)

The time complexity for the function is linear as tree traversal is involved which is linear in terms of time complexity.

Space Complexity:
O(logn) ,O(h)

The space complexity for the function is proportional to the height of the stack.
*/