package codingQuestions;

import java.util.*;
import java.util.stream.Collectors;


public class amazonMovieSolution {
    public static void main(String[] args) {

        int[] a = {1, 10, 25, 35, 60};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(movieDuration(90, (ArrayList) list));

    }


    public static ArrayList<Integer> movieDuration(int flightDuration, ArrayList<Integer> movieDuration) {
        Integer exactDuration = flightDuration - 30;

        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i = 0; i < movieDuration.size(); i++) {
            map.put(movieDuration.get(i), i);
        }


        for (Integer i = 0; i < movieDuration.size(); i++) {
            int target = exactDuration - movieDuration.get(i);

            if (map.containsKey(target)) {

                if (answer.size() > 0) {
                    int movieOne = movieDuration.get(i);
                    int movieTwo = target;
                    boolean isNew = true;

                    for (Integer v : answer) {
                        int movie = movieDuration.get(v);
                        if (movie < movieOne || movie < movieTwo) {
                            continue;
                        } else {
                            isNew = false;
                        }
                    }

                    if (isNew) {
                        answer.clear();
                        answer.add(i);
                        answer.add(map.get(target));
                    }

                } else {
                    answer.add(i);
                    answer.add(map.get(target));
                }

            }
        }

        return answer;
    }


}
