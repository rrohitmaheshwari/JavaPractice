package codingQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class AmazonPopularNFeatures {

    public static void main(String[] args) {

        AmazonPopularNFeatures a = new AmazonPopularNFeatures();

        System.out.println(a.popularNFeatures(5, 2,
                Arrays.asList("e", "d", "c", "a", "b"), 3,
                Arrays.asList("a w t b", "b u y", "a o b d d d d d d d d")));

    }

    public  ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        ArrayList<String> res = new ArrayList<>();
        PriorityQueue<Cust> pq = new PriorityQueue<>(new CustComp());

        Map<String, Integer> map = new HashMap<>();

        for (String s : possibleFeatures) {
            map.put(s.toLowerCase(), 0);
        }

        for (String fRs : featureRequests) {

            for (String key : map.keySet()) {
                if (fRs.toLowerCase().contains(key)) {
                    map.put(key, map.get(key) + 1);
                }
            }

        }

        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Cust(entry.getKey(), entry.getValue()));
            if (pq.size() > topFeatures) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }

        Collections.reverse(res);
        return res;
    }

    class Cust {
        String word;
        Integer freq;

        Cust(String word, Integer freq) {
            this.word = word;
            this.freq = freq;
        }
    }

     class CustComp implements Comparator<Cust> {
        @Override
        public int compare(Cust a, Cust b) {
            if (a.freq > b.freq)
                return 1;
            if (a.freq < b.freq)
                return -1;
            return b.word.compareTo(a.word);
        }
    }
}
