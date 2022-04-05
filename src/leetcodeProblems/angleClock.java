/*
1344. Angle Between Hands of a Clock
https://leetcode.com/problems/angle-between-hands-of-a-clock/
O(1)
O(1)
*/

class Solution {
    public double angleClock(int hour, int minutes) 
    {
        double minDegree = minutes * 6;
        double hourDegree = (hour%12) * 30.0D + minutes*0.5;
        return Math.min(Math.abs(hourDegree-minDegree) , Math.abs(360 -Math.abs(hourDegree-minDegree)));
        
    }   
}