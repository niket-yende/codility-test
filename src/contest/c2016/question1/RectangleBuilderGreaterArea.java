package contest.c2016.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Count the distinct rectangle sizes, of area greater than or equal to X, that can be built out of a given set of segments.
 * Reference: https://app.codility.com/programmers/trainings/2/rectangle_builder_greater_area/
 */
public class RectangleBuilderGreaterArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter n:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Elements:");
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        System.out.println("Enter threshold:");
        int x = Integer.parseInt(br.readLine().trim());

        int out = solution(array, x);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(Integer[] array, int x) {
        int output = 0;
        List<Integer> list = Arrays.asList(array);
        List<String> keyCombination = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                // The required combination should form a rectangular pen (enclosure)
                if(i != j && array[i] != array[j]) {
                    int combination = array[i] * array[j];
                    if(combination >= x && !isCombinationPresent(keyCombination, array[i], array[j])) {
                        int iFrequency = Collections.frequency(list, array[i]);
                        int jFrequency = Collections.frequency(list, array[j]);
                        if(iFrequency >= 2 && jFrequency >= 2) {
                            String value = array[i]+"*"+array[j];
                            keyCombination.add(value);
                        }
                    }
                }
            }
        }
        output = output < 1000000000 ? keyCombination.size() : -1;

        return output;
    }

    static boolean isCombinationPresent(List<String> keyCombination, int i, int j) {
        return keyCombination.contains(i+"*"+j) || keyCombination.contains(j+"*"+i);
    }
}
