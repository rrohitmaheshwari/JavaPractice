/*
  947. Most Stones Removed with Same Row or Column
  https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3076/
  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
*/

class Solution {
      public int removeStones(int[][] stones) {
        int count=0;
        int n = stones.length;
        int[] sets = new int[n];
          
        for(int i=0; i<n; i++){
            //setting parent as it self
            sets[i]=i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                // check if either row or column is same
                // If yes then connect them
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(sets,i,j);
                }
            }
        }
        
        // these are the ones that did not connect means clusters count
        for(int i=0; i<n; i++){
            if(sets[i]==i) count++;
        }
        
       return n-count; 
    }
    
    private void union(int[] set,int x,int y)
    {
        int a = find(set,x);
        int b = find(set,y);
        set[a] = b;
    }
    private int find(int[] sets, int v){
       /*
       could use-
      // return sets[v]==v ? v : find(sets, sets[sets[v]]);
       */
                if(sets[v] == v) // parent
                {
                    return v;
                }
                else // compressing for future finds
                {
                    sets[v] = find(sets, sets[sets[v]]);
                }
        return sets[v];
    }
}