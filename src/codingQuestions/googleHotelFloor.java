package codingQuestions;

import java.util.*;
import java.util.stream.Collectors;


public class googleHotelFloor {
    public static void main(String[] args) {

//        String[] A = {"+1A", "-1A", "+3F", "-3F", "+3F", "+8X"};
//        String[] A = {"+1A", "+3F", "+8X", "-1A", "-3F", "-8X"};
//        String[] A = {"+0A"};
//        String[] A = {"+9Z", "-9Z", "+9Z", "-9Z", "+9Z", "+3B"};
//        String[] A = {"+3B", "-3B", "+3B", "-3B", "+3B", "+9Z", "-9Z", "+9Z", "-9Z", "+9Z", "-9Z", "+9Z"};
        String[] A = {"+9Z", "-9Z", "+9Z", "-9Z", "+9Z", "-9Z", "+3B", "-3B", "+3B", "-3B", "+3B"};

        System.out.println(solution(A));


    }

    public static String solution(String[] A) {

        Map<String, Integer> m = new HashMap<>();

        int max = Integer.MIN_VALUE;
        String resString = A[0];
        int temp;
        for (String s : A) {

            if (s.charAt(0) == '+') {
                s = s.substring(1);
                temp = m.getOrDefault(s, 0) + 1;
                m.put(s, temp);

                if (max < temp) {
                    max = temp;
                    resString = s;
                } else if (max == temp && (resString.compareTo(s) > 0)) {
                    resString = s;
                }
            }

        }


        return resString;
    }


}
