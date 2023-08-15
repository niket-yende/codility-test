package contest.c2016.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.IntStream;

/**
 * Reference: https://github.com/Chaklader/Codility/blob/main/src/main/java/com/codility/Indeed_Prime_2016_Challenge/DwarfsRafting.java
 */
public class DwarfsRaftingSolution {
    private int[] dwarfs;
    private int[] capacity;

    public static void main(String[] args) {
        int n = 4;
        String s = "1B 1C 4B 1D 2A";
        String t = "3B 2D";

        int out = new DwarfsRaftingSolution().solution(n, s, t);
        System.out.println(out);
    }

    public int solution(int N, String S, String T) {

        if (N % 2 == 1) {
            return -1;
        }

        S = S.toLowerCase();
        T = T.toLowerCase();
        int[] barrels = parseString(S, N);
        dwarfs = parseString(T, N);
        capacity = new int[4];
        for (int i = 0; i < barrels.length; i++) {
            capacity[i] = (N * N / 4) - barrels[i];
        }
        int diagonal = getBalanced(0, 3);
        int antiDiagonal = getBalanced(1, 2);
        if (diagonal < 0 || antiDiagonal < 0) {
            return -1;
        }
        return diagonal + antiDiagonal - IntStream.of(dwarfs).sum();
    }

    private int charToInt(char letter) {
        return letter - 'a';
    }

    private int getBalanced(int left, int right) {

        int balance = Math.min(capacity[left], capacity[right]);

        if (balance < Math.max(dwarfs[left], dwarfs[right])) {
            return -1;
        } else {
            return balance * 2;
        }
    }

    private int[] parseString(String in, int N) {

        if (in.isEmpty()) {
            return new int[4];
        }

        int[] data = new int[4];
        String[] chunks = in.split(" ");

        for (String chunk : chunks) {

            int column = Integer.parseInt(chunk.substring(0, chunk.length() - 1));
            int row = charToInt(chunk.charAt(chunk.length() - 1));
            if (column <= N / 2) {
                if (row < N / 2) {
                    data[0]++;
                } else {
                    data[1]++;
                }
            } else {
                if (row < N / 2) {
                    data[2]++;
                } else {
                    data[3]++;
                }
            }
        }
        return data;
    }
}
