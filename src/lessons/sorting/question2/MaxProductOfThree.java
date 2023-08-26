package lessons.sorting.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 * Reference: https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree {
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
        int n = array.length;

        Arrays.sort(array);

        int maxProd1 = (array[n-1] * array[n-2] * array[n-3]);
        // Product of first 2 smallest elements with the largest element
        int maxProd2 = (array[0] * array[1] * array[n-1]);

        return Math.max(maxProd1, maxProd2);
    }
}
