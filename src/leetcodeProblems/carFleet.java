/*
853. Car Fleet
https://leetcode.com/problems/car-fleet/

O(NLogN) - Sorting
O(N) - created new array
*/

class Solution {
    
    class Car
    {
        int position;
        int speed;
        double timeToTarget;
        Car(int position, int speed,int target)
        {
            this.position = position;
            this.speed = speed;
            this.timeToTarget = (target-position)/(double)speed;
        }
        
        @Override
        public String toString()
        {
            return "position:"+position+" speed:"+speed+ " TimeToTarget:"+timeToTarget;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
       
        int len = position.length;
        
        Car inp[] = new Car[len];
        
        for(int i=0;i<len;i++)
        {
            inp[i] = new Car(position[i],speed[i],target);
        }
        
        Arrays.sort(inp,(lhs,rhs)->(lhs.position - rhs.position));
        
        
        int cnt=0;
        double time=0;
        
      for (int i = len - 1; i >= 0 ; i--) 
        {
            Car c= inp[i];
            if(c.timeToTarget>time)
            {
                time = c.timeToTarget;
                cnt++;
            }
       
        }
        
        return cnt;
        
    }
    
}