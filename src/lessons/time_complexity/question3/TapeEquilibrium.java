package lessons.time_complexity.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * Reference: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter elements:");
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
        int minDifference = Integer.MAX_VALUE;

        int sum = Arrays.stream(array).sum();

        int sumPartOne = 0;
        int sumPartTwo = 0;
        int diff = 0;

        for (int p = 1; p < array.length; p++) {
            sumPartOne = sumPartOne + array[p-1];
            sumPartTwo = sum - sumPartOne;
            diff = Math.abs(sumPartOne - sumPartTwo);

            minDifference = Math.min(minDifference, diff);
        }

        return minDifference;
    }
}
