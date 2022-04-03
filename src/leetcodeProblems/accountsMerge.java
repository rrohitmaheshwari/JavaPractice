/*
721. Accounts Merge
https://leetcode.com/problems/accounts-merge/
O(N *K + N*K (Log K)) -> O(NKLogK)
O(NK) -hashmap
*/

class Solution {
    
    class Node{
        Node parent;
        int val;
        List<String> child;
        String name;
        Node Parent()
        {
            Node p = parent;
            while(p!=p.parent)
            {
                p=p.parent;
            } 
            return p;
        }
        
        Node(int val,String name)
        {
            this.val = val;
            this.name=name;
            this.parent = this;
            this.child = new ArrayList<>();
        }
        
        @Override
        public String toString()
        {
            return name + " - "+ val+"|";
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        HashMap<String,Node> hm= new HashMap<>();
        int nodeCounter=0;
        HashSet<String> set= new HashSet<>();
        HashMap<Node,List<String>> updated= new HashMap<>();
        HashSet<String> updatedset= new HashSet<>();
        List<List<String>> res= new ArrayList<>();
            
        for(List<String> l:accounts)
        {
            Node n = new Node(nodeCounter++,l.get(0));
            for(int i=1;i<l.size();i++)
            {
                String s = l.get(i);
                if(set.contains(s))  //already seen so update the parent
                {
                    hm.get(s).Parent().parent = n.Parent();
                }
                hm.put(s,n);
                set.add(s);
            }
        }
        
        // update based on parent
         for(List<String> l:accounts)
         {
            for(int i=1;i<l.size();i++)
            {
                String s = l.get(i);

                if(updatedset.contains(s))  // already added so continue
                    continue;

                if(!updated.containsKey(hm.get(s).Parent())) 
                {
                    updated.put(hm.get(s).Parent(),new ArrayList<>());
                }
                updated.get(hm.get(s).Parent()).add(s);
                updatedset.add(s);
            }
         }
        
        for(Map.Entry<Node,List<String>> e:updated.entrySet())
        {
            List<String> l= e.getValue();
            Collections.sort(l);
            l.add(0,e.getKey().name); // adding name at first location
            res.add(l);
        }
        
        return res;
        
    }
}