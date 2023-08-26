package lessons.sorting.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Determine whether a triangle can be built from a given set of edges.
 * Reference: https://app.codility.com/programmers/lessons/6-sorting/triangle/
 *            https://github.com/Mickey0521/Codility/blob/master/Triangle.java
 */
public class Triangle {
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
        Arrays.sort(array);

        // main idea: for any combination (A[i-2], A[i-1], A[i])
        // we just need to check if A[i-2] + A[i-1] > A[i] (important)
        // note: A[i-2] + A[i-1] is the max possible combination (needed to check)

        for (int i = 2; i < array.length; i++) {
            if(array[i-1] + array[i-2] > array[i]) {
                return 1;
            }
        }
        return 0;
    }
}
