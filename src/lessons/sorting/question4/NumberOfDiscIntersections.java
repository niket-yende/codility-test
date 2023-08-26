package lessons.sorting.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Compute the number of intersections in a sequence of discs.
 * Reference: https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 *            https://github.com/Mickey0521/Codility/blob/master/NumberOfDiscIntersections.java
 */
public class NumberOfDiscIntersections {
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
        long[] lower = new long[array.length];
        long[] upper = new long[array.length];

        for (int i = 0; i < array.length; i++) {
            lower[i] = i - (long)array[i];
            upper[i] = i + (long)array[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersections = 0;
        int j = 0;

        // scan the upper points
        for (int i = 0; i < array.length; i++) {
            // for the curent "j" (lower point)
            while(j < array.length && upper[i] >= lower[j]) {
                intersections = intersections + j;
                // Avoid double count
                intersections = intersections - i;
                j++;
            }
        }

        if(intersections > 10_000_000)
            return -1;

        return intersections;
    }
}
