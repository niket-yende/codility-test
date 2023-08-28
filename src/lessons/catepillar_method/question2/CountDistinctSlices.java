package lessons.catepillar_method.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Count the number of distinct slices (containing only unique numbers).
 * Reference: https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
 *            https://github.com/Mickey0521/Codility/blob/master/CountDistinctSlices.java
 */
public class CountDistinctSlices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter M:");
        int m = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(m, array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int m, int[] array) {
        boolean[] seen = new boolean[m+1];

        int leftEnd = 0;
        int rightEnd = 0;
        int numSlice = 0;

        // key point: move the "leftEnd" and "rightEnd" of a slice
        while(leftEnd < array.length && rightEnd < array.length){
            // case 1: distinct (rightEnd)
            if(!seen[array[rightEnd]]){
                // note: not just +1
                // there could be (rightEnd - leftEnd + 1) combinations (be careful)
                numSlice = numSlice + (rightEnd - leftEnd + 1);
                if(numSlice >= 1_000_000_000)
                    return 1_000_000_000;

                // increase the slice to right by "1" (important)
                seen[array[rightEnd]] = true;
                rightEnd++;
            }
            // case 2: not distinct
            else{
                // decrease the slice from left by "1" (important)
                // remove array[leftEnd] from "seen" (be careful)
                seen[array[leftEnd]] = false;
                leftEnd++;
            }
        }

        return numSlice;
    }
}
