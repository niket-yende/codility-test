package lessons.max_slice_problem.question1;

/**
 * Given a log of stock prices compute the maximum possible earning.
 * Reference: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] array = {23171, 21011, 21123, 21366, 21013, 21367};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        int maxEarnings = 0;

        // initial entry
        int entryPrice = array[0];

        for (int i = 1; i < array.length; i++) {
            int exitPrice = array[i];

            if(exitPrice < entryPrice) {
                // Update the entryPrice
                entryPrice = exitPrice;
            } else {
                int currentEarnings = (exitPrice - entryPrice);
                if(currentEarnings > maxEarnings) {
                    maxEarnings = currentEarnings;
                }
            }
        }

        return maxEarnings;
    }
}
