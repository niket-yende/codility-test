package other.coffee_io.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Program to find the position of the rightmost different bit in the binary representation.
 * Input:
 * 52
 * 4
 * Output:
 * 5
 */
public class DifferentBit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter m:");
        int m = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter n:");
        int n = Integer.parseInt(br.readLine().trim());

        int out = solution(m, n);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int m, int n) {
        String mString = Integer.toBinaryString(m);
        String nString = Integer.toBinaryString(n);

        // pad 0 to the string with low bit value
        if (mString.length() > nString.length()) {
            int difference = mString.length() - nString.length();
            nString = padZeros(nString, difference);
        } else if (mString.length() < nString.length()) {
            int difference = nString.length() - mString.length();
            mString = padZeros(mString, difference);
        }

        int index = 1;
        for (int i = mString.length() - 1; i >= 0; i--) {
            if (mString.charAt(i) != nString.charAt(i)) {
                return index;
            }
            index++;
        }

        return 0;
    }

    static String padZeros(String input, int count) {
        String prefix = new String(new char[count]).replace("\0", "0");
        return prefix + input;
    }
}
