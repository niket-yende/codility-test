package lessons.euclidean_algorithm.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 * Reference: https://github.com/Mickey0521/Codility/blob/master/ChocolatesByNumbers_SimpleLowPerformance.java
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Ente N:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter M:");
        int m = Integer.parseInt(br.readLine().trim());

        int out = solution(n, m);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int n, int m) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int currentChocalate = 0;

        while (true) {
            currentChocalate = (currentChocalate + m) % n;
            if(set.contains(currentChocalate)) {
                break;
            } else {
                set.add(currentChocalate);
            }
        }

        return set.size();
    }
}
