package codingQuestions;

public class shiftRightCompressedString {

    public static void main(String[] args) {
        System.out.println(compressedString("abaasaaa"));
        System.out.println(compressedString("abc"));
        System.out.println(compressedString("abcc"));
        System.out.println(compressedString("abbc"));
        System.out.println(compressedString("aabc"));
        System.out.println(compressedString("a"));
    }

    private static String compressedString(String message) {
        int len = message.length();

        if (len <= 1) {
            return message;
        }

        StringBuilder res = new StringBuilder();

        int cnt;

        for (int i = 0; i < len; i++) {

            char ch = message.charAt(i);

            cnt = 1;

            while (i + 1 < len && message.charAt(i + 1) == ch) {
                i++;
                cnt++;
            }
            res.append("" + ch);

            if (cnt != 1) {
                res.append("" + cnt);
            }

        }

        return res.toString();
    }
}
