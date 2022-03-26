/*
57. Insert Interval
https://leetcode.com/problems/insert-interval/
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/445/
O(N)
O(1)
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res= new LinkedList<>();
        
        // loop and add till you find value to merge
        int index=0;
        
        while(index<intervals.length && intervals[index][1]<newInterval[0])
        {
            res.add(intervals[index]);
            index++;
        }
        
        // loop till you update the merge 
        while(index<intervals.length)
        {
            if(intervals[index][0]>newInterval[1])
                 break;
            newInterval[0] = Math.min(newInterval[0],intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[index][1]);
            
         index++;
        }

        // add expanded merge
        res.add(newInterval);

        // loop and add rest of the elements
        while(index<intervals.length)
        {
            res.add(intervals[index]);
            index++;
        }
        return res.toArray(new int[res.size()][]);
        
    }
}