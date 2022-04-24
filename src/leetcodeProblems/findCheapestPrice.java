/*
787. Cheapest Flights Within K Stops
https://leetcode.com/problems/cheapest-flights-within-k-stops/
O(NK)   -> n is number of edges and k is number of stops
O(N) -> array of n

Bellman-Ford algorithm
*/

class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
     
        // We use two arrays for storing distances and keep swapping
        // between them to save on the memory
        int[] Prices = new int[n];
        Arrays.fill(Prices, Integer.MAX_VALUE);
        
        Prices[src] = 0;
        
        // K + 1 iterations of Bellman Ford
        for (int iterations = 1; iterations <= K+1; iterations++) {
            
            int[] PricesTemp = Arrays.copyOf(Prices, n);
            
            // Iterate over all the edges
            for (int[] edge : flights) {
                
                int s = edge[0], d = edge[1], weight = edge[2];
                
                // check with the original as temp might have updated
                if(Prices[s] == Integer.MAX_VALUE)
                    continue;
                
                
                if(PricesTemp[s] + weight < PricesTemp[d])
                {
                    PricesTemp[d] = PricesTemp[s] + weight;
                }           
            }
            
            Prices = PricesTemp;
        }
        
        return Prices[dst] < Integer.MAX_VALUE ? Prices[dst] : -1;
    }
}


//  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
//     {
//         int[] cost=new int[n];
//         Arrays.fill(cost,Integer.MAX_VALUE);
//         cost[src]=0;
//         for(int i=0;i<=K;i++)
//         {
//             int[] PricesTemp= Arrays.copyOf(cost,n);
//             for(int[] f: flights)
//             {
//                 int s=f[0],d=f[1],price=f[2];
//                 if(cost[s]==Integer.MAX_VALUE)
//                     continue;
//                 PricesTemp[d]=Math.min(PricesTemp[d],cost[s]+price);
//             }
//             cost=PricesTemp;
//         }
//         return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
//     }