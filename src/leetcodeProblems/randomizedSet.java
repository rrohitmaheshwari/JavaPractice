/*
380. Insert Delete GetRandom O(1)
https://leetcode.com/problems/insert-delete-getrandom-o1/
O(1)
O(N)
*/

class RandomizedSet {

    ArrayList<Integer> numsAL;
    HashMap<Integer, Integer> hm;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numsAL = new ArrayList<Integer>();
        hm = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
        if ( hm.containsKey(val) ) 
            return false;
        hm.put( val, numsAL.size());
        numsAL.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
        if ( !hm.containsKey(val) ) 
            return false;
        
        int loc = hm.get(val);
        // not the last one than swap the last one with this val
        if (loc < numsAL.size() - 1 ) 
        { 
            int lastoneElementVal = numsAL.get(numsAL.size() - 1 );
            numsAL.set( loc , lastoneElementVal );
            hm.put(lastoneElementVal, loc);
        }
        hm.remove(val);
        numsAL.remove(numsAL.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numsAL.get( (int)(Math.random()*numsAL.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */