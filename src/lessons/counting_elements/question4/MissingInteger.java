package lessons.counting_elements.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Find the smallest positive integer that does not occur in a given sequence.
 * Reference: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingInteger {
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
        if(array.length == 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int element: array) {
            set.add(element);
        }

        for (int i = 1; i <= array.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return array.length + 1;
    }
}
