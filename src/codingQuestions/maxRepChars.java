package codingQuestions;

public class maxRepChars {

    public static void main(String[] args) {

        System.out.println(solution("aaab"));

    }

    public static int solution(String s) {

        int moves = 0;
        for (int i = 0 ; i < s.length(); i++) {
            int runLength = 1;
            for (; i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1); i++) {
                runLength++;
            }
            moves += runLength / 3;
        }
        return moves;
    }
}
