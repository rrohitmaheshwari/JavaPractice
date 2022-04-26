/*
1029. Two City Scheduling
https://leetcode.com/problems/two-city-scheduling/

Time complexity : O(NlogN) because of sorting of input data.
Space complexity : O(logN)  QuickSort space complexity is O(logN)

Now the algorithm is straightforward :

Sort the persons in the ascending order by price_A - price_B parameter, which indicates the company additional costs.

To minimise the costs, send n persons with the smallest price_A - price_B to the city A, and the others to the city B.


GREEDY
*/

class Solution {
  public int twoCitySchedCost(int[][] costs) {
    // Sort by a gain which company has 
    // by sending a person to city A and not to city B
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o1[1] - (o2[0] - o2[1]);
      }
    });

    int total = 0;
    int n = costs.length / 2;
    // To optimize the company expenses,
    // send the first n persons to the city A
    // and the others to the city B
    for (int i = 0; i < n; ++i) 
        total += costs[i][0] + costs[i + n][1];
    return total;
  }
}