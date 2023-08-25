package lessons.sorting.question1;

import java.util.Arrays;

/**
 * Compute number of distinct values in an array.
 * Reference: https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class Distinct {
    public static void main(String[] args) {
        int[] array = {2, 1, 1, 2, 3, 1};
        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        long count = Arrays.stream(array).distinct().count();
        return (int)count;
    }
}
