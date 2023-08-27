package lessons.prime_composite.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Find the minimal perimeter of any rectangle whose area equals N.
 * Reference: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 */
public class MinPerimeterRectangle {
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
        int minPerimeter = Integer.MAX_VALUE;
        int sqrtN = (int)Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if(n % i == 0) {
                int a = i;
                int b = n / i;
                int sum = a + b;
                int currentMin = 2 * sum;
                minPerimeter = Math.min(minPerimeter, currentMin);
            }
        }

        return minPerimeter;
    }
}
