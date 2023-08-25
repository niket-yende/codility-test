package lessons.time_complexity.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Find the missing element in a given permutation.
 * Reference: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {
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
        int missingElement = 0;
        
        int n = array.length + 1;
        long expectedSum = (n * (n + 1)) / 2;
        long actualSum = 0L;
        for (int num: array) {
            actualSum += num;
        }

        missingElement = (int)(expectedSum - actualSum);
        return missingElement;
    }
}
