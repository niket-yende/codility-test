package contest.c2017.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Given the numbers of players and available courts, calculate the maximum number of parallel tennis games.
 * Reference: https://app.codility.com/programmers/trainings/3/tennis_tournament/
 */
public class TennisTournament {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter players P:");
        int p = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter courts C:");
        int c = Integer.parseInt(br.readLine().trim());

        int out = solution(p, c);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int p, int c) {
        int output = 0;
        int playersPerCourt = 2;

        // Case to play max 2 players per court
        if(p >= c * playersPerCourt) {
            // Occupy all the courts
            output = c;
        } else {
            for (int i = 0; i < c; i++) {
                if(p >= playersPerCourt) {
                    p -= playersPerCourt;
                    output += 1;
                } else {
                    break;
                }
            }
        }

        return output;
    }
}
