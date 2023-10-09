package other.coffee_io.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Write a program to rotate array in left by k rotations.
 * Original array: [11, 22, 33, 44, 55, 66, 77]
 * Rotated array: [44, 55, 66, 77, 11, 22, 33]
 */
public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter array elements:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Enter K rotations:");
        int k = Integer.parseInt(br.readLine().trim());

        solution(array, n, k);

        wr.close();
        br.close();
    }

    static void solution(int[] array, int n, int k) {
        if(n != array.length) {
            System.out.println("Mismatched array length");
        }

        System.out.println("Original array: "+Arrays.toString(array));

        // Iterate for k rotations
        for (int i = 0; i < k; i++) {
            array = rotateLeft(array, n);
        }

        System.out.println("Rotated array: "+ Arrays.toString(array));
    }

    static int[] rotateLeft(int[] array, int n) {
        int temp = array[0];

        for (int i = 0; i < n-1; i++) {
            array[i] = array[i+1];
        }
        array[n-1] = temp;

        return array;
    }

}
