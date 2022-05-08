/*
901. Online Stock Span
https://leetcode.com/problems/online-stock-span/
O(N)
O(N)

Monotonic stack solution

Ref: https://www.youtube.com/watch?v=slYh0ZNEqSw
11:02 timeStamp for image
*/

class StockSpanner {

    Stack<Pair<Integer,Integer>> st;
    public StockSpanner() {
        this.st = new Stack<>();
    }
    
    public int next(int price) 
    {
        int span = 1;
        while(!this.st.isEmpty() && st.peek().getKey()<=price)
        {
            span += st.pop().getValue();
        }
        st.add(new Pair(price,span));
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */