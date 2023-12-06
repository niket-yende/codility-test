package other.coffee_io.level8;

import java.util.Scanner;

/**
 * Write a program to find the shortest string
 * Input:
 * abac
 * cab
 * Output:
 * cabac
 */
public class ShortestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }

    static String solution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build the DP matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the shortest string
        int i = m, j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    result.insert(0, str1.charAt(i - 1));
                    i--;
                } else {
                    result.insert(0, str2.charAt(j - 1));
                    j--;
                }
            }
        }

        // Append remaining characters from str1 and str2
        while (i > 0) {
            result.insert(0, str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.insert(0, str2.charAt(j - 1));
            j--;
        }

        return result.toString();
    }
}
