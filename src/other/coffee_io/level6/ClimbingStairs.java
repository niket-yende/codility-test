package other.coffee_io.level6;

import java.util.Scanner;

/**
 * Implement a program to climb stairs using the Dynamic Programming(DP) approach.
 * Input:
 * 3
 * Output:
 * 3
 *
 * Reference: https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    static int solution(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
