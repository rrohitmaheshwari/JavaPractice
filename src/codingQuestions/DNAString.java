package codingQuestions;

public class DNAString {

    public static void main(String[] args) {
        System.out.println(dnaComplement("GTCAG"));
    }

    public static String dnaComplement(String s) {
        return new StringBuilder(s
                .replace('A', 't')
                .replace('T', 'a')
                .replace('C', 'g')
                .replace('G', 'c')
        ).reverse().toString().toUpperCase();

    }
}
