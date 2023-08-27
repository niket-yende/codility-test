package lessons.prime_composite.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Find the maximum number of flags that can be set on mountain peaks.
 * Input: 1 5 3 4 3 4 1 2 3 4 6 2
 * Output: 3
 *
 * Reference: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 */
public class Flags {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array) {
        int maxFlags = Integer.MIN_VALUE;
        List<Integer> peakList = new ArrayList<>();

        // Start index from 1 since prev would be 0
        // End index with arr.length - 2 since next would be last value
        for (int i = 1; i <= array.length - 2; i++) {
            int currentElement = array[i];
            int leftNeighbour = array[i - 1];
            int rightNeighbour = array[i + 1];

            // The element is peak if it is greater than its neighbours
            if(currentElement > leftNeighbour && currentElement > rightNeighbour) {
                peakList.add(i);
            }
        }

        // Distance b/w two flags must be greater than equal to K flags
        for (int j = peakList.size() - 1; j >= 0; j--) {
            int k = j;
            int maxPeaks = j + 1;
            int flags = 0;

            // Bypass condition
            if(j < maxFlags) {
                break;
            }

            while(k > 0) {
                int currentPeak = peakList.get(j);
                int prevPeak = peakList.get(k - 1);
                int peakDiff = Math.abs(currentPeak - prevPeak);
                if(peakDiff >= maxPeaks) {
                    flags++;
                }
                k--;
            }

            maxFlags = Math.max(maxFlags, flags);
        }

        return maxFlags;
    }
}
