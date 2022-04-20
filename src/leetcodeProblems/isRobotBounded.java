/*
1041. Robot Bounded In Circle
https://leetcode.com/problems/robot-bounded-in-circle/
O(N)
O(1)

here catch it to check the initial position and directions
*/

class Solution {
   

    public boolean isRobotBounded(String instructions) 
    {
        int x=0,y=0;
        // North -> Up, East -> right, South -> Down, West -> left
        int Directions[][]= new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        int directionKey = 0; // default North
        
        for(int i=0;i<instructions.length();i++)
        {
            switch(instructions.charAt(i))
            {
                case 'G':
                    x+=Directions[directionKey][0];
                    y+=Directions[directionKey][1];
                    break;
                case 'R':
                    directionKey++;
                    directionKey = directionKey%4;
                    break;
                case 'L':
                    directionKey--;
                    directionKey = (directionKey+4)%4;
                    break;
            }
        }
        
        if((x==0 && y==0) || directionKey!=0)
        {
            return true;
        }
        return false;
    }
}