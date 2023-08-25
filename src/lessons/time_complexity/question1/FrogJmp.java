package lessons.time_complexity.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Count minimal number of jumps from position X to Y.
 * Reference: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJmp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter X:");
        int x = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter Y:");
        int y = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter D:");
        int d = Integer.parseInt(br.readLine().trim());

        int out = solution(x, y, d);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int x, int y, int d) {
        int jumps = 0;

        int travelDistance = y - x;
        jumps = Math.toIntExact(travelDistance / d);
        int remainingDistance = travelDistance % d;
        if(remainingDistance > 0) {
            // Final jump to cover the remaining distance
            jumps += 1;
        }

        return jumps;
    }
}
