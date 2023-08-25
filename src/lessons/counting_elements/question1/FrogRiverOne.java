package lessons.counting_elements.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Find the earliest time when a frog can jump to the other side of a river.
 * Reference: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class FrogRiverOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter X:");
        int x = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter elements:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(x, array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int x, int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= x; i++) {
            set.add(i);
        }

        for (int j = 0; j < array.length; j++) {
            if(set.contains(array[j])) {
                set.remove(array[j]);
            }

            if(set.isEmpty()) {
                return j;
            }
        }

        return -1;
    }
}
