package lessons.counting_elements.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Check whether array A is a permutation.
 * Reference: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
public class PermCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out  = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array) {
        boolean visited[] = new boolean[array.length];
        Arrays.fill(visited, false);

        for (int element: array) {
            // Check if the element is within the scope
            // Element must be b/w 1 to N
            // Check if the element is already visited
            if(element < 1 || element > array.length || visited[element - 1]) {
                return 0;
            }
            visited[element - 1] = true;
        }

        return 1;
    }
}
