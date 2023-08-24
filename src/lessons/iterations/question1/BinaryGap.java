package lessons.iterations.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Find longest sequence of zeros in binary representation of an integer.
 * Reference: https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {
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
        // remove the trailing zeros
        while (n != 0 && (n & 1) == 0) {
            n >>>= 1;
        }
        System.out.println("Value of n after removing trailing zeros: "+n);

        int max = 0;
        int gap = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                gap++;
                max = Math.max(gap, max);
            } else {
                gap = 0;
            }
            n >>>= 1;
        }
        return max;
    }
}
