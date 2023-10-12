package other.coffee_io.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Program to reverse bits of a number
 *
 * Input: 3
 * Output: 3221225472
 */
public class ReverseBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter n:");
        int n = Integer.parseInt(br.readLine().trim());

        long out = solution(n);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static long solution(int n) {
        long result = reversedBitsNum(n);

        return result;
    }

    public static long reversedBitsNum(int n) {
        long dn = 0; // variable for new decimal number
        int j = 30; // initial value of j
        // loop to find the reversed binary bit
        for (int i = 0; i < 32; i++) {
            int k = ((n >> i) & 1); // k will be the required bit
            if (k != 0) { // if bit is set then only convert in decimal
                if (j == -1) { // since if j = -1 then left shift operator will not work
                    dn = Math.abs(dn) + (long)Math.pow(2, 0);
                } else {
                    dn = Math.abs(dn) + (2 << j); // here left shift operator calculates 2 to power j for making code efficient
                }
            }
            j--; // j is decreased in each iteration
        }
        return Math.abs(dn);
    }
}
