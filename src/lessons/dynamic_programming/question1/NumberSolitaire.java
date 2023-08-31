package lessons.dynamic_programming.question1;

/**
 * In a given array, find the subset of maximal sum in which the distance between consecutive elements is at most 6.
 * Reference: https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 *            https://github.com/Mickey0521/Codility/blob/master/NumberSolitaire.java
 */
public class NumberSolitaire {
    public static void main(String[] args) {
        int[] array = {1, -2, 0, 9, -1, -2};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];

        // build up from "dp[1], dp[2], ..., dp[array.length-1]"
        for(int i=1; i<array.length; i++){
            // keep the biggest one
            // be very careful: could be negtive (so use Integer.MIN_VALUE)
            int max = Integer.MIN_VALUE;

            // a die could be "1 to 6"
            for(int die=1; die<=6; die++){
                if( i-die >= 0){
                    // very important: not "array[i-die]+array[i]"
                    // instead, have to use "dp[i-die]+array[i]"
                    max = Math.max( dp[i-die]+array[i], max );
                    // dynamic programming:
                    // take the best:
                    // takeBest( dp[i-j] + value[j], curBest )
                }
            }
            dp[i] = max; // keep the best one as the dp value
        }

        return dp[array.length-1];
    }
}
