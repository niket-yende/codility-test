package other.test;

import java.util.Arrays;

/**
 * Program to implement counting sort.
 * Reference: https://www.baeldung.com/java-counting-sort
 *
 * Input array: [4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5]
 * c array: [1, 2, 4, 6, 8, 11]
 * Sorted array: [0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5]
 */
public class CountingSort {

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int k = 5;
        int[] input = { 4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5 };
        System.out.println("Input array: "+Arrays.toString(input));

        int[] sorted = countingSort.sort(input, k);
        System.out.println("Sorted array: "+Arrays.toString(sorted));
    }

    public int[] countElements(int[] input, int k) {
        int[] c = new int[k + 1];
        Arrays.fill(c, 0);

        for (int i : input) {
            c[i] += 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        return c;
    }

    public int[] sort(int[] input, int k) {
        int[] c = countElements(input, k);
        System.out.println("c array: "+Arrays.toString(c));

        int[] sorted = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int current = input[i];
            sorted[c[current] - 1] = current;
            c[current] -= 1;
        }

        return sorted;
    }
}
