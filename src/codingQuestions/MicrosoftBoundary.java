package codingQuestions;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

public class MicrosoftBoundary {

    public static void main(String[] args) {

        List<List<Integer>> inp = new ArrayList<>();
        inp.add(Arrays.asList(1, 2, 11, 12));
        inp.add(Arrays.asList(2, 3, 11));
        inp.add(Arrays.asList(3, 4, 5, 6, 7, 8, 11));
        inp.add(Arrays.asList(5, 9, 10, 8, 7, 6, 5));

        System.out.println(findBoundary(inp));
    }

    static List<Integer> findBoundary(List<List<Integer>> inp) {
        HashMap<Edge, Integer> hm = new HashMap<>();
        int a, b;

        for (List<Integer> ls : inp) {
            for (int i = 0; i < ls.size() - 1; i++) {
                hm.put(new Edge(ls.get(i), ls.get(i + 1)), hm.getOrDefault(new Edge(ls.get(i), ls.get(i + 1)), 0) + 1);
            }
            if (ls.get(0) != ls.get(ls.size() - 1))
                hm.put(new Edge(ls.get(0), ls.get(ls.size() - 1)), hm.getOrDefault(new Edge(ls.get(0), ls.get(ls.size() - 1)), 0) + 1);

        }


        Map<Integer, List<Integer>> polygon = new HashMap<>();
        for (Map.Entry<Edge, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey().a + " " + entry.getKey().b + " - " + entry.getValue());
            if (entry.getValue() == 1) {
                Edge temp = entry.getKey();
                if (!polygon.containsKey(temp.a)) {
                    polygon.put(temp.a, new ArrayList<>());
                }
                if (!polygon.containsKey(temp.b)) {
                    polygon.put(temp.b, new ArrayList<>());
                }
                polygon.get(temp.a).add(temp.b);
                polygon.get(temp.b).add(temp.a);
            }

        }


        System.out.println(polygon);

        HashSet<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();


        int point = polygon.entrySet().iterator().next().getKey();
        int oldPoint;
        while (!seen.contains(point)) {
            List<Integer> temp = polygon.get(point);
            oldPoint = point;
            for (int i : temp) {
                if (seen.contains(i)) {
                    continue;
                } else {
                    res.add(point);
                    seen.add(point);
                    point = i;
                    break;
                }
            }
            if (oldPoint == point) {
                break;
            }

        }
        res.add(point);
        return res;

    }

    static class Edge {
        int a;
        int b;

        Edge(int a, int b) {
            int i = Math.min(a, b);
            int j = Math.max(a, b);
            this.a = i;
            this.b = j;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || obj.getClass() != this.getClass())
                return false;

            Edge geek = (Edge) obj;

            return (geek.a == this.a && geek.b == this.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }


    }


}
