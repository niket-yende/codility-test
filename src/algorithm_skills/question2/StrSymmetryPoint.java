package algorithm_skills.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StrSymmetryPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter input string:");
        String input = br.readLine().trim();

        int out = solution(input);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(String s){
        int output = 0;

        if(s.length() == 1){
            return output;
        }

        int mid = Math.round(s.toCharArray().length / 2);
        String leftSubstring = new StringBuffer(s.substring(0, mid)).toString();
        String reversedRightSubString = new StringBuffer(s.substring(mid+1, s.length())).reverse().toString();

        if(leftSubstring.equals(reversedRightSubString)) {
            output = mid;
        } else {
            output = -1;
        }

        return output;
    }
}
