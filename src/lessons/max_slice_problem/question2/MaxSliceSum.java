package lessons.max_slice_problem.question2;

import java.util.Arrays;

/**
 * Find a maximum sum of a compact subsequence of array elements.
 * Reference: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 */
public class MaxSliceSum {
    public static void main(String[] args) {
        int[] array = {3, 2, -6, 4, 0};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        int maxPrevious = array[0];
        int maxCurrent = array[0];
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++) {
            maxCurrent = Math.max(array[i], maxPrevious + array[i]);
            maxPrevious = maxCurrent;
            maxSum = Math.max(maxSum, maxCurrent);
        }

        return maxSum;
    }
}
