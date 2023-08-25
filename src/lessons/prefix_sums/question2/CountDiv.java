package lessons.prefix_sums.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Compute number of integers divisible by k in range [a..b].
 * Reference: https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class CountDiv {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter A:");
        int a = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter B:");
        int b = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter K:");
        int k = Integer.parseInt(br.readLine().trim());

        int out = solution(a, b, k);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int a, int b, int k) {
        // Handling boundary conditions separately
        int difference = (b - a) - 1;

        int numDivisible = difference / k;

        if(a % k == 0) {
            numDivisible++;
        }
        if(b % k == 0) {
            numDivisible++;
        }

        return numDivisible;
    }
}
