package other.coffee_io.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Program to find unique number
 * Input: 2 2 4 6 6
 * Output: 4
 */
public class UniqueNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter elements:");
        String[] input = br.readLine().trim().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int out = solution(array, n);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array, int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(!set.contains(array[i])){
                set.add(array[i]);
            } else {
                set.remove(array[i]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        if(list.size() > 0) {
            return list.get(0);
        }

        return 0;
    }
}
