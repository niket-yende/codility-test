package lessons.prefix_sums.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Count the number of passing cars on the road.
 * Reference: https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 */
public class PassingCars {
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
        int numEast = 0;
        int numPass = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                numEast++;
            }

            if(array[i] == 1) {
                numPass = numPass + numEast;
            }
        }

        if(numPass > 1_000_000_000)
            return -1;
        else
            return numPass;
    }
}
