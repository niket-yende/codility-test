package lessons.dynamic_programming.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Given array of integers, find the lowest absolute sum of elements.
 * Reference: https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
 */
public class MinAbsSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array) {
        int out = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            int j = 0;
            while (j < array.length) {
                // Sequence value
                int s = j % 2 == 0 ? 1 : -1;
                int value = Math.abs(array[i] + s);
                out = Math.min(out, value);
                j++;
            }
        }

        return out;
    }
}
