package other.coffee_io.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Write a program to find first set bit from the right
 *
 * Input: 18
 * Output: 2
 *
 * Reference: https://www.techiedelight.com/convert-number-to-binary-java/
 */
public class FindFirstSetBit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        int out = solution(n);
        System.out.println("First set position from right: "+out);

        wr.close();
        br.close();
    }

    static int solution(int n) {
        StringBuffer binaryString = new StringBuffer(Integer.toBinaryString(n));
        binaryString.reverse();

        char searchChar = '1';
        int index = binaryString.toString().indexOf(searchChar);

        if(index >= 0) {
            // position starts from 1
            return index + 1;
        }

        return 0;
    }
}
