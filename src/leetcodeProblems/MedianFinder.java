/*
295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/
O(4* logN)-add    O(1)-find
O(N) - as we used heap
*/

class MedianFinder 
{

    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;
    
    public MedianFinder() 
    {
        l = new PriorityQueue<Integer>((lhs,rhs)->(Integer.valueOf(rhs)-Integer.valueOf(lhs))); // max heap
        r = new PriorityQueue<Integer>();//min heap
        
    }
    
    public void addNum(int num) 
    {
        //always add in l
        l.add(num);

        // check if l has less value than r otherwise change
       if(r.size()!=0 && l.peek() > r.peek())
          {
              r.add(l.poll());
              l.add(r.poll());
          }
        
        // balance the size
        if(l.size()-r.size() == 2)
        {
            r.add(l.poll());
        }

    }
    
    public double findMedian() 
    {
     if(l.size()==r.size())
         return (double)(l.peek()+r.peek())/2;
        return (double)l.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */