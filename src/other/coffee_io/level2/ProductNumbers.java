package other.coffee_io.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Program to find product factorial using recursion
 *
 * Input: 5
 * Output: 120
 */
public class ProductNumbers {
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

    static int solution(int num) {
        if(num <= 1) {
            return 1;
        } else {
            return num * solution(num - 1);
        }
    }
}
