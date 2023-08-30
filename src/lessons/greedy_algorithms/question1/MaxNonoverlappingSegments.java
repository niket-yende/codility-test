package lessons.greedy_algorithms.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Find a maximal set of non-overlapping segments.
 * Reference: https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
 *            https://github.com/Mickey0521/Codility/blob/master/MaxNonoverlappingSegments.java
 */
public class MaxNonoverlappingSegments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter arary A:");
        String[] inputA = br.readLine().trim().split(" ");

        int[] a = new int[inputA.length];
        for (int i = 0; i < inputA.length; i++) {
            a[i] = Integer.parseInt(inputA[i]);
        }

        System.out.println("Enter arary B:");
        String[] inputB = br.readLine().trim().split(" ");

        int[] b = new int[inputB.length];
        for (int i = 0; i < inputB.length; i++) {
            b[i] = Integer.parseInt(inputB[i]);
        }

        int out = solution(a, b);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int[] a, int[] b) {
        // main idea:
        // Using "greedy" method to find non-overlapping segments

        // because the segments are sorted by their rightEnds
        // we use "for loop" from rightEnd to left
        // and just need to keep the "value of leftEnd" (key point)

        if(a.length==0)
            return 0;

        int n = a.length;
        // keep the value of leftEnd: a[i]
        // the 1st segment: a[n-1]
        int currentLeftEnd = a[n-1];
        int numNonOverlap = 1;

        for(int i = n-2; i >= 0; i--){
            // if "rightEnd < leftEnd", nonOverlap++
            // and update the value of leftEnd
            if(b[i] < currentLeftEnd){
                numNonOverlap++;
                currentLeftEnd = a[i];
            }
            // if "leftnEnd is shorter",
            // update the value of leftEnd (important)
            if(a[i] > currentLeftEnd){
                currentLeftEnd = a[i];
            }
        }

        return numNonOverlap;
    }
}
