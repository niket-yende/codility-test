package data_structures.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Calculate the number of slices in which (maximum - minimum <= K).
 * Reference: https://app.codility.com/programmers/trainings/7/count_bounded_slices/
 */
public class CountBoundedSlices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter number of elements:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Elements:");
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        System.out.println("Enter value of K:");
        int k = Integer.parseInt(br.readLine().trim());

        int out = solution(k, array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int k, Integer[] array) {
        int output = 0;
        List<List<Integer>> boundedSlices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i] <= array[j] && (array[j] - array[i] <= k)) {
                    boundedSlices.add(Arrays.asList(i, j));
                }
            }
        }

        output = boundedSlices.size();

        return output;
    }
}
