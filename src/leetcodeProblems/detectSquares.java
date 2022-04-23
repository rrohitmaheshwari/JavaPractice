/*
2013. Detect Squares
https://leetcode.com/problems/detect-squares/
O(N)
O(N)

This sol is for only 1st quadrant
*/

class DetectSquares { 
    int[][] cntPoints = new int[1001][1001]; // or use hashMap
    List<int[]> points = new ArrayList<>();

    public void add(int[] p) 
    {
        cntPoints[p[0]][p[1]] += 1;
        points.add(p);
    }

    public int count(int[] p1) 
    {
        int x1 = p1[0], y1 = p1[1], ans = 0;
        
        for (int[] p3 : points) 
        {
            int x3 = p3[0], y3 = p3[1];
            
            if (Math.abs(x1-x3) == 0 || Math.abs(x1-x3) != Math.abs(y1-y3))
                continue; // Skip empty square or invalid square point!
            
            ans += cntPoints[x1][y3] * cntPoints[x3][y1];
        }
        return ans;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */