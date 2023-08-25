package lessons.counting_elements.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 * Reference: https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *            https://github.com/Mickey0521/Codility/blob/master/MaxCounters.java
 */
public class MaxCounters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter array A:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int[] out = solution(n, array);
        System.out.println(Arrays.toString(out));

        wr.close();
        br.close();
    }

    static int[] solution(int n, int[] array) {
        int[] outputArray = new int[n];

        int max = 0;
        int min = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 1 && array[i] <= n) {
                if(outputArray[array[i]-1] < min) {
                    outputArray[array[i]-1] = min;
                }

                outputArray[array[i]-1]++;

                if(outputArray[array[i]-1] > max) {
                    max = outputArray[array[i]-1];
                }
            } else if (array[i] == n+1) {
                min = max;
            }
        }

        for (int j = 0; j < outputArray.length; j++) {
            if(outputArray[j] < min) {
                outputArray[j] = min;
            }
        }

        return outputArray;
    }
}
