package contest.c2017.question4;

import java.util.HashMap;
import java.util.Map;

/**
 * Given points on a plane, count the number of sets of four points that form regular diamonds.
 * Reference: https://app.codility.com/programmers/trainings/3/diamonds_count/
 */
public class DiamondsCount {
    public static void main(String[] args) {
        int[] X = {1, 1, 2, 2, 2, 3, 3};
        int[] Y = {3, 4, 1, 3, 5, 3, 4};
        System.out.println(solution(X, Y)); // Output: 2

        int[] X2 = {1, 2, 3, 3, 2, 1};
        int[] Y2 = {1, 1, 1, 2, 2, 2};
        System.out.println(solution(X2, Y2)); // Output: 0
    }

    static int solution(int[] X, int[] Y) {
        int output = 0;

        return output;
    }
}
