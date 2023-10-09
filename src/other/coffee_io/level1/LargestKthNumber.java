package other.coffee_io.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Program to find the kth smallest and largest elements
 * Input:
 * n: 6
 * elements: 7 10 4 3 20 15
 * k: 4
 *
 * Output:
 * Kth smallest element: 10
 * Kth largest element: 7
 */
public class LargestKthNumber {
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

        System.out.println("Enter K index:");
        int k = Integer.parseInt(br.readLine().trim());

        solution(array, n, k);

        wr.close();
        br.close();
    }

    static void solution(int[] array, int n, int k) {
        Arrays.sort(array);

        int searchIndex = k-1;
        int maxIndex = (n-1)-searchIndex;
        System.out.println("Kth smallest element: "+array[searchIndex]);
        System.out.println("Kth largest element: "+array[maxIndex]);
    }


}
