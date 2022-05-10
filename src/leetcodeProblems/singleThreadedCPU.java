/*
1834. Single-Threaded CPU
https://leetcode.com/problems/single-threaded-cpu/
O(NlogN)
O(N)
*/

class Solution {
    public int[] getOrder(int[][] tasks) {
        // 1. sort the tasks by starting time
        // 2. use a minHeap to store current tasks with a custom
        // 3. terate each task, if task starting time is smaller or equal to cur, we add into the pq
        // 4. check if pq is empty, then we update current time by ith task starting time
        // 5. if not empty we update the result
        int[][] allTasks = new int[tasks.length][3]; // index, starting time and totalTime
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2] == 0 ? a[0] - b[0] : a[2] - b[2]);
        for (int i = 0; i < tasks.length; i++) {
            allTasks[i][0] = i;
            allTasks[i][1] = tasks[i][0];
            allTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(allTasks, (a, b) -> a[1] - b[1]);
        
        int i = 0, index = 0, curTime = 0;
        int[] result = new int[tasks.length];
        
        while (index < tasks.length) {
            // check if i th tasks starting time is smaller or equal to currenttime
            while (i < tasks.length && curTime >= allTasks[i][1]) 
            {
                minHeap.add(allTasks[i++]);
            }
            if (minHeap.isEmpty()) 
            {
                curTime = allTasks[i][1];
            }
            else 
            {
                int[] curTask = minHeap.remove();
                result[index++] = curTask[0];
                curTime += curTask[2];
            }
        }
        
        return result;
    }
}