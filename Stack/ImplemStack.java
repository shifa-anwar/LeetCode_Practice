/*
Implement Stack using queue
*/
1. using two queue
class MyStack {
    Queue<Integer> q1;
    Queue<Integer>q2;
    public MyStack() {
        q1= new LinkedList<>();
        q2= new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty())
        { 
         q1.offer(x);
         return;
        }
        while(!q1.isEmpty()) //remove all element from q1 and add to q2
            q2.offer(q1.poll());
        q1.offer(x); 
        while(!q2.isEmpty()) //again add al element of q2 to q1 this will reverse the queue 
         q1.offer(q2.poll());   
    }
    
    public int pop() {
       if(q1.isEmpty())
           return -1;
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}

2.Using one Queue
class MyStack {
   Queue<Integer> q;
    public MyStack() {
       q= new LinkedList<>();
    }
    
    public void push(int x) {
     if(q.isEmpty())
     {
      q.offer(x);
      return;   
     }
    q.offer(x);
      while(q.peek()!=x) 
  /*remove elemen from rear and then add it to front till
    you get the element to be push at top
  */
      {
        q.offer(q.poll());  
      }
    }
    
    public int pop() {
       return q.poll();
    }
    
    public int top() {
       return q.peek();
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}
