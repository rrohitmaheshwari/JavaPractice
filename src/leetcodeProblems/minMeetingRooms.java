/*
253. Meeting Rooms II
https://leetcode.com/problems/meeting-rooms-ii/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3059/
O(NlogN)
O(N)
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {

    if (intervals.length == 0) {
      return 0;
    }

    Integer[] start = new Integer[intervals.length];
    Integer[] end = new Integer[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

   
    Arrays.sort(end);
    Arrays.sort(start);

    int startPointer = 0, endPointer = 0;
    int usedRooms = 0;

    // Iterate over intervals.
    while (startPointer < intervals.length) {

      // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
      if (start[startPointer] >= end[endPointer]) {
        usedRooms -= 1;
        endPointer += 1;
      }

      // We do this irrespective of whether a room frees up or not.
      // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
      // remain the same in that case. If no room was free, then this would increase used_rooms
      usedRooms += 1;
      startPointer += 1;

    }

        // we dont care if endPointer reaches end as start pointer will cover all the meetings
    return usedRooms;
  }
}