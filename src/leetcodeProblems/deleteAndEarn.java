/*
740. Delete and Earn
https://leetcode.com/problems/delete-and-earn/
O(NlogN) - used sorting
O(N)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        // count 
        HashMap<Integer,Integer> cnt =new HashMap<>();
        List<Integer> parsedList = new ArrayList<>();
        for(int i:nums)
        {
            if(!cnt.containsKey(i))
            {
                parsedList.add(i);
            }
            cnt.put(i,cnt.getOrDefault(i,0)+1);   // can also do  cnt.put(i,cnt.getOrDefault(i,0)+i);
        }
        
        // sort list
        Collections.sort(parsedList);
        
        int earn1=0, earn2=0;
        
        for(int i=0;i<parsedList.size();i++)
        {
            int currEarn = parsedList.get(i) * cnt.get(parsedList.get(i)); // cnt.get(parsedList.get(i))
            
            if(i>0 && parsedList.get(i-1) == parsedList.get(i)-1)
            {
                int temp = earn2;
                earn2 = Math.max(currEarn+earn1,earn2);
                earn1 = temp;
            }
            else
            {
                
                int temp = earn2; 
                earn2 = currEarn + earn2;
                earn1 = temp;
                
            }
            
        }
        
        return earn2;
        
    }
}