/*
155. Min Stack
https://leetcode.com/problems/min-stack/
O(1)
O(N)
*/
class MinStack {

    Stack<Pair<Integer,Integer>> s;
    public MinStack() {
        s= new Stack<>();
    }
    
    public void push(int val) {
         int min;
        if(!s.isEmpty())
        {
            min = Math.min(val,s.peek().getValue());
        }
        else
        {
            min = val;
        }
        s.push(new Pair(val,min));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().getKey();
    }
    
    public int getMin() {
        return s.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */