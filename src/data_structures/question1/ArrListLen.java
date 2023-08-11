package data_structures.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compute length of a single-link list encoded in an array.
 * Reference: https://app.codility.com/programmers/trainings/7/arr_list_len/
 */
public class ArrListLen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter number of elements:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Elements:");
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(Integer[] array) {
        int output = 0;
        List<Integer> linkedArray = Arrays.asList(array);

        if(!linkedArray.contains(-1)) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] == -1 && i != array.length-1) {
                array[i] = array[array.length - 1];
                array[array.length - 1] = -1;
            }

            if(i == array.length-1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i]+"->");
            }
        }

        output = array.length - 1;

        return output;
    }
}
