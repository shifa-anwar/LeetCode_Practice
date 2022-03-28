class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    int index;
    public StockSpanner() {
    stack= new Stack<>();
    list=new ArrayList<>(); 
     index=0;   
    }
    
    public int next(int price) {
        int count=0;
        list.add(price);
        while(!stack.isEmpty() && price>=list.get(stack.peek()))
         stack.pop();   
        if(stack.size()==0)
         count=index+1;
        else
         count=index-stack.peek();
        stack.push(index);
         index++;
        return count;
    }
}
