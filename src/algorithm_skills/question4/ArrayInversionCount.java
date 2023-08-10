package algorithm_skills.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInversionCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter number of elements of array:");
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
        int output = -1;
        List<List<Integer>> inversions = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
           List<Integer> inversionSet = new ArrayList<>();
           int currentElement = array[i];
           for (int j = i + 1; j < array.length; j++) {
                if(currentElement > array[j]) {
                    inversionSet.addAll(Arrays.asList(currentElement, array[j]));
                    inversions.add(inversionSet);
                }
           }
        }
        output = inversions.size() > 0 ? inversions.size() : output;

        return output;
    }
}
