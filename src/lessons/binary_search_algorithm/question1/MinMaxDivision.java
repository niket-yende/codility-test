package lessons.binary_search_algorithm.question1;

/**
 * Divide array A into K blocks and minimize the largest sum of any block.
 * Reference: https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 *            https://github.com/Mickey0521/Codility/blob/master/MinMaxDivision.java
 */
public class MinMaxDivision {
    public static void main(String[] args) {
        int k = 3;
        int m = 5;
        int[] array = {2, 1, 5, 1, 2, 2, 2};

        int out = solution(k, m, array);
        System.out.println(out);
    }

    static int solution(int k, int m, int[] array) {
        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < array.length; i++) {
            maxSum = maxSum + array[i];
            minSum = Math.max(minSum, array[i]);
        }

        int result = maxSum;

        while(minSum <= maxSum) {
            int midSum = (minSum + maxSum) / 2;

            boolean divisible = isDivisible(midSum, k, array);

            if(divisible) {
                result = midSum;
                maxSum = midSum - 1;
            } else {
                minSum = midSum + 1;
            }
        }

        return result;
    }

    static boolean isDivisible(int midSum, int k, int[] array) {
        int allowedBlocks = k;
        int currentBlockSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentBlockSum = currentBlockSum + array[i];

            if(currentBlockSum > midSum) {
                currentBlockSum = array[i];
                allowedBlocks--;
            }

            if(allowedBlocks == 0) {
                return false;
            }
        }

        return true;
    }
}
