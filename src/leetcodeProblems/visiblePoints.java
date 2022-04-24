/*
1610. Maximum Number of Visible Points
https://leetcode.com/problems/maximum-number-of-visible-points/
O(NLogN)
O(N)

Coppied from Leetcode Solution
*/

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int countOfSameLoc = 0;
        for(List<Integer> point : points) {
            int dx = point.get(0) - location.get(0); 
            int dy = point.get(1) - location.get(1);
            
            if(dx == 0 && dy == 0) {
                countOfSameLoc++; // if the point lies on the 'location' itself, it comes in the view ALWAYS (so ADD them in last)
            } else {
                double degree = Math.atan2(dy, dx) * (180/Math.PI); // Math.atan2(dy, dx) finds the radian of point (x, y) and +ve X-Axis
                angles.add(degree);
            }
        }
        
        Collections.sort(angles); // now the angles are from -ve to + ve
        
        int n = angles.size();
        for(int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360); // now all angles are CIRCULAR (-150 degree is 210) and (10 degree is now 370)

            if(angles.get(i)>angle)  // small optimization || can be removed
            {
                break;
            }
        }
        
        int begin = 0; // classic sliding window variable 
        int res = 0;
        
        for(int end = 0; end < angles.size(); end++) {
            // increase 'end' until 'if' condtion doesn't suffice; as soon as 'if' if true, meaning we have gone OUT of VIEW of the 'angle' so we need to increase the lower angle i.e 'begin'
            while(angles.get(end) - angles.get(begin) > angle) { // this should be 'while' and not 'if' (sliding window always uses 'while')
                begin++;
            }
            
            res = Math.max(res, end - begin + 1); // we need to return the MAX points that can come in VIEW (inside the 'angle' of watch)
        }
        
        res += countOfSameLoc; // these are the points that lies on same location as that of 'location' so ALWAYS add them
        
        return res;
    }
}