package other.coffee_io.level8;

import java.util.Scanner;

/**
 * Program to return min no. of steps for s palindrome.
 * Example 1:
 * Input: s = "mbadm"
 * Output: 1
 * Explanation:
 * The string can be "mbdadbm" or "mdbabdm"
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation:
 * Inserting 5 characters the string becomes "leetcodocteel"
 */
public class MinStepsToPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static int solution(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
