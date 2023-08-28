package lessons.catepillar_method.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Compute number of distinct absolute values of sorted array elements.
 * Input: -5 -3 -1 0 3 6
 * Output: 5
 *
 * Reference: https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
 */
public class AbsDistinct {
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
        Set<Integer> valueSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int absValue = Math.abs(array[i]);
            if(!valueSet.contains(absValue)) {
                valueSet.add(absValue);
            }
        }

        return valueSet.size();
    }
}
