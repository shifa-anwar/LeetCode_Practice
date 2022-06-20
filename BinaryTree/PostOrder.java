/*
145. Binary Tree Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/
//Recursive Soln
class Solution {
    List<Integer> path = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
     if(root==null)
     {
      return path;   
     }   
     postorderTraversal(root.left);
     postorderTraversal(root.right);
     path.add(root.val);
     return path;   
    }
}
//Iterative Soln
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> path = new ArrayList<>();  
     if(root==null)
     {
      return path;   
     }   
    Stack<TreeNode> st = new Stack<>();
    st.push(root);    
    while(st.size()>0)
    {
     TreeNode top = st.pop();   
     if(top.left!=null)
     {
       st.push(top.left);  
     }
        if(top.right!=null)
        {
         st.push(top.right);   
        }
        path.add(top.val);
    }
     Collections.reverse(path);   
     return path;   
    }
}