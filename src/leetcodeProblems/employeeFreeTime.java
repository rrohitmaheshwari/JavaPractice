/*
759. Employee Free Time
https://leetcode.com/problems/employee-free-time/
O(NLogK)
O(K) - pq size
*/

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
       //Create a priority queue with a comparator on the start of the first interval  in each list of intervals
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
       //Populate the priority queue with the first interval from each list
        for (int i = 0; i < schedule.size(); i++) {
            //each element in the priority queue has 2 indexes. 0 points to the List on the List of schedules. 1 points to the index within the list selected by 0
            pq.add(new int[] {i, 0});
        }
        
        //Initialize the result arraylist
        List<Interval> res = new ArrayList<>();
        
        //set previous to the end of the first interval 
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        
        while (!pq.isEmpty()) {
            
           //Get next interval from queue
            int[] index = pq.poll();
            
            Interval interval = schedule.get(index[0]).get(index[1]);
            
            if (interval.start > prev) {
                //No overlap, so add the gap in intervals
                res.add(new Interval(prev, interval.start));
            }
            
            prev = Math.max(prev, interval.end);
            
            if (schedule.get(index[0]).size() > index[1] + 1) {
                //Add the next interval into the priority queue, add the next element
                //from the  list whose interval was polled
                pq.add(new int[] {index[0], index[1] + 1});
            }
        }
        return res;
    }
}