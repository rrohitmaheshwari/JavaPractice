/*
489. Robot Room Cleaner
https://leetcode.com/problems/robot-room-cleaner/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/
*/

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    Robot robot;
    Set<Pair<Integer,Integer>> v = new HashSet<>();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0,0,0);
    }
    
  public void goBack() {
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnRight();
    robot.turnRight();
  }
    
    void backtrack(int i,int j,int d)
    {
        v.add(new Pair(i,j));
        //clean the area
        robot.clean();
        
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    for (int k = 0; k < 4; ++k) {
      int newD = (d + k) % 4;
      int newRow = i + directions[newD][0];
      int newCol = j + directions[newD][1];

      if (!v.contains(new Pair(newRow, newCol)) && robot.move()) {
        backtrack(newRow, newCol, newD);
        goBack();
      }
      // turn the robot following chosen direction : clockwise
      robot.turnRight();
    }
        
        
    }
    
}