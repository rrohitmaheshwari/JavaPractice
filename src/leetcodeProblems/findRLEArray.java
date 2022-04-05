/*
1868. Product of Two Run-Length Encoded Arrays
O(N+M)
O(1)
*/

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        
        List<List<Integer>> res= new ArrayList<>();
        
        int p1=0,p2=0;
        while(p1<encoded1.length)
        {
            int len=Math.min(encoded1[p1][1],encoded2[p2][1]);
            int mult =encoded1[p1][0]*encoded2[p2][0];
                
            if(res.size() >0 && mult == res.get(res.size()-1).get(0))
            {
                // append to old entry.  [6,2][6,3] = [6,5]
                res.get(res.size()-1).set(1,res.get(res.size()-1).get(1)+len);
            }
            else
            {
                // new entry
                res.add(Arrays.asList(mult,len));
            }
            
            encoded1[p1][1]-=len;
            encoded2[p2][1]-=len;
            if(encoded1[p1][1]==0)
                p1++;
            if(encoded2[p2][1]==0)
                p2++;
        }
        
        return res;    
    }
}