/*
346. Moving Average from Data Stream
https://leetcode.com/problems/moving-average-from-data-stream/
O(1)
O(N)
*/

class MovingAverage {

    int size;
    int sum;
    int cntr;
    Deque queue = new ArrayDeque<Integer>();
    public MovingAverage(int size) {
        this.size=size;
        this.sum=0;
        cntr=0;
    }
    
    public double next(int val) {
        cntr++;
        if(cntr<=size)
        {
            sum+=val;

        }
        else
        {
            int p = (int)(queue.poll());
            sum=sum-p+val;
            cntr--;
        }
         queue.add(val);
         return sum*1.0/cntr;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */