import java.util.Stack;
class Node
{
  int data;
  Node left,right;
  Node(int data,Node left,Node right)
  {
   this.data=data; 
   this.left=left;
   this.right=right;
  }  
}
class Pair
{
Node node;
int state;
Pair(Node node,int state)
{
this.node = node;
this.state = state;
}    
}

public class Main 
{
    public static Node construct(Integer arr[])
{
    Node root = new Node(arr[0],null,null);
    Stack<Pair> st = new Stack<>();
    Pair p = new Pair(root,1);
    st.push(p);
    int idx=1;
    while(st.size()>0)
    {
    Pair top = st.peek();
    if(top.state==1)
    {
    idx++;
    if(arr[idx]!=null)
    {
       top.node.left = new Node(arr[idx],null,null);
       Pair lp = new Pair(top.node.left,1);
       st.push(lp);
    }
    else
    {
     top.node.left = null;
    }
    top.state++;    
    }
    else if(top.state==2)
    {
     idx++;
     if(arr[idx]!=null)
     {
     top.node.right=new Node(arr[idx],null,null);
     Pair rp = new Pair(top.node.right,1);
     st.push(rp);
     }
     else
     {
     top.node.right=null;
     }
     top.state++;
    }
    else
    {
       st.pop(); 
    }
    }
    return root;    
}
public static void display(Node node)
{
if(node==null)
{
 return;   
}
String str ="";
str+=node.left==null?".":node.left.data;
str+="<-"+node.data+"->";
str+=node.right==null?".":node.right.data;
System.out.println(str);
display(node.left);
display(node.right);
}
public static int size(Node node)
{
if(node==null)
{
  return 0;  
}
int ls = size(node.left);
int rs = size(node.right);
int ts = ls+rs+1;
return ts;
}
public static int sum(Node node)
{
  if(node==null)
  {
   return 0; 
  }
  int ls = sum(node.left);
  int rs = sum(node.right);
  int ts = ls+rs+node.data;
  return ts;  
}
public static void main(String[] args) 
    {
        Integer []arr = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        display(root);
        System.out.println("Size is : "+size(root));
        System.out.println("Sum is : "+sum(root));
    }
}
