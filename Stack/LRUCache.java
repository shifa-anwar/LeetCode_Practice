class Node
{
 int key,value;
 Node next,prev;
 public Node(int key,int value)
 {
     this.key=key;
     this.value=value;
 }
}
class LRUCache
{

    //Constructor for initializing the cache capacity with the given value.
    static Node head,tail;
    static int size,capacity;
   static  HashMap<Integer,Node> map;
    LRUCache(int cap)
    {
        //code here
     capacity=cap;
     map= new HashMap<>();
     head= new Node(0,0);
     tail=new Node(0,0);
     head.next=tail;
     tail.prev=head;
     tail.next=null;
     head.prev=null;
     size=0;
    }
    static void remove(Node node)
     {
        if(size==1)//only one node is there in list
        {
        head =tail=null;    
        }
        else if(node==head) //remove first 
        {
            head =head.next;
            head.prev=null;
        }
        else if(node==tail)//remove last
        {
        tail=tail.prev;   
        tail.next=null;
        }
        else //remove from between
        {
        Node n1 = node.prev;
        Node n2 = node.next;
        n1.next=n2;
        n2.prev=n1;
        }
         size--;
     }
    static void addFirst(int key,int value)
     {
         Node curr = new Node(key,value);
         if(size==0)
         {
        head = tail=curr;     
         }
         else
         {
             head.prev=curr; 
            curr.next=head;
            head=curr;
         }
         size++;
     }
    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        if(map.containsKey(key))
        {
         /*
          if value is present in map  
          */
           Node temp = map.get(key);
           remove(temp);
           addFirst(key,temp.value);
           map.put(key,head);
           return temp.value;
        }
       else
       {
        return -1;
       }
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if(map.containsKey(key))
        {
          Node temp = map.get(key);
          remove(temp);
          addFirst(key,value);
          map.put(key,head);
        }
        else
        {
        if(size==capacity)
        {
         map.remove(tail.key);
         remove(tail);
         addFirst(key,value);
         map.put(key,head);
        }
        else
        {
          addFirst(key,value);
          map.put(key,head);
        }
        }
    }
}
