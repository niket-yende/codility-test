package other.coffee_io.level7;

import java.util.Scanner;

/**
 * Program to find the minimum sum of a special path (from the first row to the last row) through the matrix.
 * Input:
 * 3
 * 2 1 3
 * 6 5 4
 * 7 8 9
 * Output:
 * 13
 * Explanation: There are two falling paths with a minimum sum of 13.
 *
 * Input:
 * 2
 * -19 57
 * -40 -5
 * Output:
 * -59
 * Explanation: There is exactly one falling path with a minimum sum of -59.
 */
public class MinimumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(arr, n));
    }

    static int solution(int[][] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = arr[i - 1][j];
                if (j > 0) {
                    minPrev = Math.min(minPrev, arr[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minPrev = Math.min(minPrev, arr[i - 1][j + 1]);
                }
                arr[i][j] += minPrev;
            }
        }

        int minSum = arr[n - 1][0];
        for (int j = 1; j < n; j++) {
            minSum = Math.min(minSum, arr[n - 1][j]);
        }

        return minSum;
    }
}
