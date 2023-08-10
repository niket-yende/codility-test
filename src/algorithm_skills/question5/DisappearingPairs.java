package algorithm_skills.question5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Reference: https://app.codility.com/programmers/trainings/4/disappearing_pairs/
 */
public class DisappearingPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter the string:");
        String s = br.readLine().trim();

        String out = solution(s);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static String solution(String input) {
        if((!input.contains("AA") && !input.contains("BB") && !input.contains("CC")) || input.equals("")) {
            return input;
        } else {
            if(input.contains("AA")) {
                input = input.replaceFirst("AA", "");
            } else if (input.contains("BB")) {
                input = input.replaceFirst("BB", "");
            } else if (input.contains("CC")) {
                input = input.replaceFirst("CC", "");
            }
            return solution(input);
        }
    }
}
