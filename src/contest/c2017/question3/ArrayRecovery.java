package contest.c2017.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Recover a broken array using partial information in another array.
 * Reference: https://app.codility.com/programmers/trainings/3/array_recovery/
 */
public class ArrayRecovery {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter M:");
        int m = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter B array:");
        String[] array = br.readLine().trim().split(" ");
        int[] b = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            b[i] = Integer.parseInt(array[i]);
        }

        int out = solution(b, m);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] B, int M) {
        int N = B.length;
        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int prev = B[i - 1];
            dp[i] = (dp[i] + dp[i - 1]) % MOD;

            if (prev == 0) {
                for (int j = 1; j <= M; j++) {
                    dp[i] = (dp[i] + dp[i - 1]) % MOD;
                }
            } else {
                for (int j = prev + 1; j <= M; j++) {
                    dp[i] = (dp[i] + dp[i - 1] - dp[prev]) % MOD;
                    if (dp[i] < 0) {
                        dp[i] += MOD;
                    }
                }
            }
        }

        return (int) dp[N];
    }
}
