package lessons.arrays.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Rotate an array to the right by a given number of steps.
 * Reference: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter A:");
        String[] input = br.readLine().trim().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Enter K:");
        int k = Integer.parseInt(br.readLine().trim());

        int[] out = solution(array, k);
        System.out.println(Arrays.toString(out));

        wr.close();
        br.close();
    }

    static int[] solution(int[] array, int k) {
        int[] rotatedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            // using "mod" to do Cyclic Rotation
            int newPosition = (i + k) % array.length;
            rotatedArray[newPosition] = array[i];
        }

        return rotatedArray;
    }
}
