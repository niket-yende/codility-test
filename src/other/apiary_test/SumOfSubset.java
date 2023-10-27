package other.apiary_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to find the sum  of subset of array of any 3 consecutive numbers.
 *
 * Input: [4, 3, 5, 8, 10, 0, 1, 2]
 * Output:
 * First element index: 2
 * Max sum: 23
 */
public class SumOfSubset {
    public static void main(String[] args) {
        int[] a = {4, 3, 5, 8, 10, 0, 1, 2};
        solution(a);
    }

    static void solution(int[] array) {
        int maxSum = 0;
        int index = 0;

        for (int i = 0; i < array.length - 2; i++) {
            int tempSum = findSum(array, i);
            if(tempSum > maxSum) {
                maxSum = tempSum;
                index = i;
            }
        }
        System.out.println("First element index: "+index);
        System.out.println("Max sum: "+maxSum);
    }

    static int findSum(int[] array, int index) {
        int sum = 0;
        for (int i = index; i < index + 3; i++) {
            sum += array[i];
        }
        return sum;
    }
}
