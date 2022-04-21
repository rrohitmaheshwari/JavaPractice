/*
146. LRU Cache
https://leetcode.com/problems/lru-cache/
O(1)
O(N)
*/

class LRUCache {
    
    // Double Linkend List
      private  class Node {
        private int key, val;
        private Node next, prev;
        
        private Node() {}
        
        private Node(int key, int val) 
        {
            this.key = key;
            this.val = val;
        } 
          
    }
    
    // head point to most recently used
    private Node head, tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        map = new HashMap<>(capacity);
        
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        // if key is not present
        if (!map.containsKey(key)) 
            return -1;
        
        // move to First
        moveFirst(map.get(key));
       
        // return the node val
        return map.get(key).val;
    }
    
    public void put(int key, int val) {
        Node putNode;
        if (map.containsKey(key))   // if key already exists
        {
            putNode = map.get(key);
            putNode.val = val;
            moveFirst(putNode);
        }
        else 
        {
           if (map.size() == capacity) // if capacity is full remove element from last
           {
                map.remove(tail.prev.key);
                remove(tail.prev);
           }
            putNode = new Node(key, val);
            addFirst(putNode);
            map.put(key, putNode);
        }
        
    }
    
    private void remove(Node node) 
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addFirst(Node node) 
    {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
    
    private void moveFirst(Node node) 
    {
        remove(node);
        addFirst(node);
    }
    
  
}