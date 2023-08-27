package lessons.prime_composite.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Count factors of given number n.
 * Reference: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 *            https://github.com/Mickey0521/Codility/blob/master/CountFactors.java
 */
public class CountFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        int out = solution(n);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int n) {
        int numFactor = 0;
        int sqrtN = (int)Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if(n % i == 0) {
                numFactor++;
            }
        }

        numFactor = numFactor * 2;

        // Handle duplicate count
        if(sqrtN * sqrtN == n) {
            numFactor--;
        }

        return numFactor;
    }
}
