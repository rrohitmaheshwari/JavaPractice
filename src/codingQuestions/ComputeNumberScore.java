package codingQuestions;

public class ComputeNumberScore {

    public static void main(String[] args) {
        ComputeNumberScore ob = new ComputeNumberScore();
        System.out.println(ob.compute_number_score(456));
    }

    static int compute_number_score(int number) {
        int res = 0;
        res += checkFiveCount(number);
        res += checkConsecutiveThree(number);
        res += checkSequence(number);
        res += checkFiveMultiple(number);
        res += checkOddDigit(number);
        return res;
    }

    //2 point for every 5
    static int checkFiveCount(int number) {
        int points = 0;
        while(number > 0) {
            if((number % 10) == 5) {
                points += 2;
            }
            number = number / 10;
        }

        return points;
    }


    //4 points for every consecutive 3
    static int checkConsecutiveThree(int number) {
        int points = 0;
        int pair = 0;

        while(number > 0) {
            if((number%10) == 3) {
                pair++;
                if(pair >= 2) {
                    points += 4;
                }
            } else {
                pair = 0;
            }
            number = number / 10;
        }

        return points;
    }


    static int checkSequence(int number) {
        int points = 0;
        String str = String.valueOf(number);
        for(int i = 0; i < str.length(); i++) {
            int mult=1;

            while( i+1<str.length() && (Character.getNumericValue(str.charAt(i))+1 == Character.getNumericValue(str.charAt(i+1)))){
                i++;
                mult++;
            }
            points += Math.pow(mult,2);
        }
        return points;
    }

    //6 point for every 5
    static int checkFiveMultiple(int number) {
        return (number % 5 == 0 ? 6 : 0);
    }

    //1 point for every odd
    static int checkOddDigit(int number) {
        int points = 0;
        while(number > 0) {
            if((number % 2) != 0) {
                points+=1;
            }
            number/=10;
        }
        return points;
    }
}
