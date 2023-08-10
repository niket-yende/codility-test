package coding_skills.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ThreeLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter value for A");
        Integer a = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter value for B");
        Integer b = Integer.parseInt(br.readLine().trim());

        String out = solution(a, b);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static String solution(int a, int b) {
        StringBuilder output = new StringBuilder();

        while (a > 0 || b > 0) {
            String lastAddedSequence = output.length() >= 2 ? output.substring(output.length() - 2) : output.toString();
            if (a > b && (!lastAddedSequence.equals("aa"))) {
                output.append("a");
                a--;
            } else if (b > 0 && (!lastAddedSequence.equals("bb"))) {
                output.append("b");
                b--;
            } else if (a > 0) {
                output.append("a");
                a--;
            }
        }

        return output.toString();
    }
}
