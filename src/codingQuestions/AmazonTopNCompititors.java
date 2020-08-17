package codingQuestions;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class AmazonTopNCompititors {

    public static void main(String[] args) {


        AmazonTopNCompititors aObj = new AmazonTopNCompititors();
        System.out.println(aObj.topNCompetitors(6, 2,
                Arrays.asList("newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"),
                6,
                Arrays.asList("newshop is providing good serices in the city; everyone should use newshop",
                        "best services by newshop",
                        "fashionbeats has great service in the city",
                        "i am proud to have",
                        "mymarket has awesome serivices fashionbeats",
                        "Thanks Newshop for the quick delivery.")));

    }


    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        ArrayList<String> res = new ArrayList<>();
        PriorityQueue<CustomClass> pq = new PriorityQueue<>(new CustomClassComparator());

        Map<String, Integer> map = new HashMap<>();

        for (String s : competitors) {
            map.put(s.toLowerCase(), 0);
        }

        for (String review : reviews) {
            for (String key : map.keySet()) {
                if (review.toLowerCase().contains(key)) {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new AmazonTopNCompititors.CustomClass(entry.getKey(), entry.getValue()));
            if (pq.size() > topNCompetitors) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }

        Collections.reverse(res);
        return res;
    }

    class CustomClass {
        String word;
        Integer frequency;

        CustomClass(String word, Integer frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    class CustomClassComparator implements Comparator<CustomClass> {
        @Override
        public int compare(CustomClass a, CustomClass b) {
            if (a.frequency > b.frequency)
                return 1;
            if (a.frequency < b.frequency)
                return -1;
            return b.word.compareTo(a.word);
        }
    }

}
