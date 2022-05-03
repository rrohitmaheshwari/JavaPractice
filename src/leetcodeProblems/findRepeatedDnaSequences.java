/*
187. Repeated DNA Sequences
https://leetcode.com/problems/repeated-dna-sequences/solution/
O((N - 10)* 10) -> O(N)
O((N-10) * 10) -> O(N)

use hashset
*/

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    int L = 10, n = s.length();
      
    HashSet<String> seen = new HashSet(), output = new HashSet();

    // iterate over all sequences of length L
    for (int start = 0; start < n - L + 1; ++start) {
      String tmp = s.substring(start, start + L);
      if (seen.contains(tmp)) 
          output.add(tmp);
        seen.add(tmp);
    }
    return new ArrayList<String>(output);
  }
}