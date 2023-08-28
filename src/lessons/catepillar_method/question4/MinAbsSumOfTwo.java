package lessons.catepillar_method.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Find the minimal absolute value of a sum of two elements.
 * Reference: https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
 */
public class MinAbsSumOfTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array) {
        int minAbsSum = Integer.MAX_VALUE;

        int startIndex = 0;
        while(startIndex < array.length) {
            for (int i = startIndex; i < array.length; i++) {
                int currentAbsSum = Math.abs(array[startIndex] + array[i]);
                minAbsSum = Math.min(minAbsSum, currentAbsSum);
            }
            startIndex++;
        }

        return minAbsSum;
    }
}
