package other.coffee_io.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Program to find the min special year.
 * Input: 1987
 * Output: 2013
 */
public class SpecialYear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter start year N:");
        int n = Integer.parseInt(br.readLine().trim());

        int out = solution(n);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(int n) {
        int specialYear = n + 1;
        while(!distinctDigits(specialYear)) {
            specialYear++;
        }

        return specialYear;
    }

    static boolean distinctDigits(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 0) {
            int temp = n % 10;
            if(set.contains(temp)) {
                return false;
            }
            set.add(temp);
            n = n / 10;
        }

        return true;
    }
}
