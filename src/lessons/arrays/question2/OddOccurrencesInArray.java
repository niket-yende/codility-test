package lessons.arrays.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OddOccurrencesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter n:");
        int n = Integer.parseInt(br.readLine().trim());

        int[] array = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            System.out.println("A["+i+"] = ");
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] array) {
        if(array.length == 0) {
            return 0;
        }

        int unpaired = array[0];

        for (int i = 1; i < array.length; i++) {
            unpaired = unpaired ^ array[i];
        }

        return unpaired;
    }
}
