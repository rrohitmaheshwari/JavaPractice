package codingQuestions;

public class microsoftLowerUpper {

    public static void main(String[] args) {
        System.out.println(solution("aAbBaA"));
        System.out.println(solution("Codility"));
        System.out.println(solution("WeTestCodeErs"));
    }

    public static String solution(String S) {
        boolean[][] chCount = new boolean[26][2];
        int temp;
        int current_num = -1;
        for (char ch : S.toCharArray()) {

            if (ch <= 'Z') {
                temp = ch - 'A';
                chCount[temp][0] = true;
            } else {
                temp = ch - 'a';
                chCount[temp][1] = true;
            }


            if (chCount[temp][0] && chCount[temp][1] && (temp > current_num )) {
                current_num = temp;
            }
        }
        if (current_num == -1)
            return "NO";
        else
            return (Character.toString((char)('A' + current_num)));
    }

}
