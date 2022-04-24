/*
792. Number of Matching Subsequences
https://leetcode.com/problems/number-of-matching-subsequences/

Time: O(N + S), where N <= 5*10^4 is length of string s, S <= 5000*50 is sum length of all words
Space: O(M), where M <= 5000 is size of words.


Copied from:
https://leetcode.com/problems/number-of-matching-subsequences/discuss/1290406/C%2B%2BJavaPython-Next-Letter-Pointers-Picture-explain-O(N-%2B-S)

Diagram in above link
*/

class Node {
    String word;
    int index;
    Node(String word, int index) 
    {
        this.word = word;
        this.index = index;
    }
}
class Solution {
    public int numMatchingSubseq(String s, String[] words) 
    {
        // bucket for each char.  'a' -> arrayList, 'b' -> arrayList,....'z'
        ArrayList<Node>[] buckets = new ArrayList[26];
        
        for (int i = 0; i < 26; ++i) 
            buckets[i] = new ArrayList<>();
        
        // create initial buckets
        for (String word : words) 
        {
            char startingChar = word.charAt(0);
            buckets[startingChar-'a'].add(new Node(word, 0));
        }
        
        int ans = 0;
        
        for (char c : s.toCharArray()) 
        {
            ArrayList<Node> currBucket = buckets[c-'a'];
            buckets[c-'a'] = new ArrayList<>();
            
            for (Node node : currBucket) 
            {
                node.index += 1; // Point to next character of node.word
                if (node.index == node.word.length()) 
                {
                    ans += 1;
                } 
                else 
                {
                    char startingChar = node.word.charAt(node.index);
                    buckets[startingChar - 'a'].add(node);
                }
            }
        }
        return ans;
    }
}