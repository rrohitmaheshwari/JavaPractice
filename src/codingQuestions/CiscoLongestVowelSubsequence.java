package codingQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CiscoLongestVowelSubsequence {

    public static void main(String[] args) {

        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        System.out.println(repeatedString("aioeoooiioieueoaiieaeaoeioiiaueueiououeiueeaaueeueaeoaaaouoeoieouaauooeuuoeauuaauaeoeeuiueeeuiieooeuaooeiaeueaaaaiooeaoiiiaaaooeiioaiiieieauaoeuiiueuioouuaoaioeiaiaaaaoeeaiuiaeoiiuauiiaeiuuaoaeaaaaeoeueieoaaaooueioaauieieouoeouieaueuuaiiueoouioueuaaauaoeueuoouieuuouuoueoaaeuuouueieuouiooaiuaoeuaeiaueuuieeiuaaeuiuuiuoiaiaeauuuaeeuuuuoieoieuaoiiuoeiaeaeeauoueaiuooiaoaiuoouoeeueeuaoeueiaiioiouueeaaoeoeauouuieeoaoioauieeeieeaaiuiaaeiaeueuouuaoaoiiaoeoaoeuieeouiiiiauauueaeouaeeeaoeaaaeouuueoeoiueeoeiouaoeaaeeoaeaiiuouoaaeiuaiaeueuauaoauueuoeueueauuuueeeeuaouaaueaiouoeuooeiouoiiiueauauaeuaauuoeuoaeeouoouoeeeoieoaouiaaioiuoeuaaouuiioieoiiaueueuieouaiioeuaeoeieaoeiuooueeoeuueueioaoaauoooiiueueooeuouauuaiuiaoieeeeoouoeiaaaeieiooeouioeuooeeiauouueiuieaeaieeooaoeiuu"));

    }

    public static int repeatedString(String s) {

        s = s.substring(s.indexOf('a'));

        Map<Character, Integer> counting = new HashMap();
        counting.put('a', 0);
        counting.put('e', 0);
        counting.put('i', 0);
        counting.put('o', 0);
        counting.put('u', 0);

        char temp = ' ';

        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                temp = ch;
            else if (ch == 'e')
                temp = counting.get('a') > counting.get(ch) ? 'a' : ch;
            else if (ch == 'i')
                temp = counting.get('e') > counting.get(ch) ? 'e' : ch;
            else if (ch == 'o')
                temp = counting.get('i') > counting.get(ch) ? 'i' : ch;
            else if (ch == 'u')
                temp = counting.get('o') > counting.get(ch) ? 'o' : ch;

            counting.put(ch, counting.get(temp) + 1);
        }
        return counting.get('u');
    }

    static int longestMegicalSubsequence(String s, char[] c) {

        // exit conditions
        if (s.length() == 0 || c.length == 0) {
            return 0;
        }

        if (s.length() < c.length) {
            return 0;
        }

        if (s.length() == c.length) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != c[i]) {
                    return 0;
                }
            }
            return s.length();
        }

        if (s.charAt(0) < c[0]) {

            return longestMegicalSubsequence(s.substring(1), c);
        } else if (s.charAt(0) == c[0]) {

            return Math.max(Math.max(
                    (1 + longestMegicalSubsequence(s.substring(1),
                            Arrays.copyOfRange(c, 1, c.length))),
                    (1 + longestMegicalSubsequence(s.substring(1), c))),
                    (longestMegicalSubsequence(s.substring(1), c)));
        } else {
            return longestMegicalSubsequence(s.substring(1), c);
        }
    }
}
