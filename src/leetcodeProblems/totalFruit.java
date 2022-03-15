/*
  Fruit Into Baskets
https://leetcode.com/explore/interview/card/google/67/sql-2/3046/
*/

class Solution {
    public int totalFruit(int[] fruits) {
   int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < fruits.length; j++) 
        {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
        
            if(map.size() > 2)
            {
                maxCount = Math.max(maxCount, j - i);
                
                do{
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                    if (map.get(fruits[i]) == 0) 
                    {
                        map.remove(fruits[i]);
                    }
                    i++;
                } while (map.size() > 2);
            }
        }
        return Math.max(maxCount, fruits.length - i );
    }
}
