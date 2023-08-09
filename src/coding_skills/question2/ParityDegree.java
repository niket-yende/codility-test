package coding_skills.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ParityDegree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        Integer input = Integer.parseInt(br.readLine().trim());

        int out = solution(input);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int n){
        int highestPower = 0;

        while(n % 2 == 0) {
            n /= 2;
            highestPower++;
        }
        return highestPower;
    }
}
