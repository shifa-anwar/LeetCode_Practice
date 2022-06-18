/* 
Binary Tree Level Order Traversal(or breadth first traversal)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        if(root==null)
        {
           return li; 
        }
        ArrayList<Integer> l;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0)
        {
         l = new ArrayList<>();   
         int c = q.size();
         for(int i=0;i<c;i++)
         {
         root = q.remove();    
         l.add(root.val);
         if(root.left!=null)
         {
          q.add(root.left);   
         }
         if(root.right!=null)
         {
          q.add(root.right);   
         }
         }
        li.add(l);
        }
       return li; 
    }
}
Time complexity:O(n)
space complexity:O(n)