/*
1553. Minimum Number of Days to Eat N Oranges
https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
O(N)  -> actually its O(logN) as log N would be height of tree
O(N)  -> actually its O(logN) as log N would be height of tree
*/

class Solution {
    
    public int minDays(int n) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        return dfs(n,hm);
    }
    
    int dfs(int n,HashMap<Integer,Integer> hm )
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(hm.containsKey(n))
            return hm.get(n);
        
        int one= 1+(n%2)+dfs(n/2,hm);
        int two= 1+(n%3)+dfs(n/3,hm);
        hm.put(n,Math.min(one,two));
        
        return Math.min(one,two);
        
    }
}