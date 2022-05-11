/*
716. Max Stack
https://leetcode.com/problems/max-stack/
O(N)
O(N)
*/

class MaxStack {
    
    Stack<Integer> normalStack;
    Stack<Integer> maxStack;

    public MaxStack() {
        normalStack = new Stack<>();
        maxStack = new Stack<>();
        
    }
    
    public void push(int x) {
        normalStack.push(x);
        if(maxStack.isEmpty())
        {
           maxStack.push(x); 
        }
        else
        {
            maxStack.push(Math.max(x,maxStack.peek())); 
        }
        
    }
    
    public int pop() {
        maxStack.pop();
        return normalStack.pop();
        
    }
    
    public int top() {
        
        return normalStack.peek();
        
    }
    
    public int peekMax() {
        return maxStack.peek();
        
    }
    
    public int popMax() {
        int popMaxElement = maxStack.peek();
        
        Stack<Integer> buffer = new Stack<>();
        
        while(normalStack.peek() != popMaxElement)
        {
            buffer.push(pop()); // note this will pop from both max in normal
        }
        
        pop();  
        
        while(!buffer.isEmpty())
        {
            push(buffer.pop()); // note this will add to both max in normal
        }
        
        return popMaxElement;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */