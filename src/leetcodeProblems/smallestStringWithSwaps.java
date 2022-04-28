/*
1202. Smallest String With Swaps
https://leetcode.com/problems/smallest-string-with-swaps/
O(E+VLogV)- E will for creating adj list. DFS take (E+V) as vertex is only visited once. Sorting VlogV
O(E+V+logV) - ajd list E, V for visited and indexes store; Sorting will also take logV 
Intiution: convert problem intp graph. Check for disjoint componenets via DFS
Sort those components and create output.
*/
class Solution {
    boolean[] visited;
    List<Integer>[] adj;
    
  // main funtion
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        visited = new boolean[s.length()];
        adj = new ArrayList[s.length()]; 
         
        for (int i = 0; i < s.length(); i++) 
        {
            adj[i] = new ArrayList<Integer>();
        }

        // Build the adjacency list
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);
            
            // Undirected edge
            adj[source].add(destination);
            adj[destination].add(source);
        }
        
        char[] answer = new char[s.length()];
        for (int vertex = 0; vertex < s.length(); vertex++) {
            // If not covered in the DFS yet
            if (!visited[vertex]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                DFS(s, vertex, characters, indices);
                // Sort the list of characters and indices
                Collections.sort(characters);
                Collections.sort(indices);

                // Store the sorted characters corresponding to the index
                for (int index = 0; index < characters.size(); index++) {
                    answer[indices.get(index)] = characters.get(index);
                }
            }
        }
        return new String(answer);
    }


    private void DFS(String s, int vertex, List<Character> characters, List<Integer> indices) {
        // Add the character and index to the list
        characters.add(s.charAt(vertex));
        indices.add(vertex);
        
        visited[vertex] = true;
        
        // Traverse the adjacents
        for (int adjacent : adj[vertex]) {
            if (!visited[adjacent]) {
                DFS(s, adjacent, characters, indices);
            }
        }
    }
}