package lessons.sieve_of_eratosthenes.question1;

import java.util.Arrays;

/**
 * Calculate the number of elements of an array that are not divisors of each element.
 * Reference: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 3, 6};

        int[] out = solution(array);
        System.out.println(Arrays.toString(out));
    }

    static int[] solution(int[] array) {
        int n = array.length;
        int[] outputArray = new int[n];
        int processedIndex = 0;

        while(processedIndex < n) {
            int processedElement = array[processedIndex];
            int count = 0;
            for (int i = 0; i < n; i++) {
                int currentElement = array[i];
                if(processedElement % currentElement != 0) {
                    count++;
                }
            }

            outputArray[processedIndex] = count;
            processedIndex++;
        }

        return outputArray;
    }

}
