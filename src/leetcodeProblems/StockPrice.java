/*
2034. Stock Price Fluctuation
https://leetcode.com/problems/stock-price-fluctuation/
O(log N) -> insertion and fetching from TM.....since we are fetching from hm in current its timecomplexity is O(1)
O(N)
*/

class StockPrice {

    Map<Integer, Integer> line; // timeStamp, Price
    TreeMap<Integer, Integer> tm;  // price,count

    int latestTimestamp = 0;

    public StockPrice() {
        line = new HashMap<>();
        tm = new TreeMap<>();
    }

    public void update(int timestamp, int price) 
    {
        // check latest or highest timestamp
        latestTimestamp = Math.max(latestTimestamp, timestamp); 

        // Assuming: 1 <= timestamp, price 
        int oPrice = line.getOrDefault(timestamp, 0); 
        
        // if (op == price) return;

        if (oPrice != 0) // means op already exisit in tm
        {
            int cnt = tm.get(oPrice) - 1;  //update count
            if (cnt == 0) 
                tm.remove(oPrice);  // no element exist for oPrice
            else 
                tm.replace(oPrice, cnt); //reduce cnt
        }
       // add or update entry to line
        line.put(timestamp, price); 
        
        // add or update entry to tm
        tm.put(price, tm.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return line.get(latestTimestamp);
    }

    public int maximum() {
        return tm.lastKey();
    }

    public int minimum() {
        return tm.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */