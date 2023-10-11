package other.coffee_io.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Program to check if the characters of each string and return value accordingly.
 * a = b => 0
 * a < b => -1
 * a > b => 1
 *
 * Input: abcdefg
 *        AbCdEfF
 * Output: 1
 */
public class Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter string 1:");
        String str1 = br.readLine().trim();

        System.out.println("Enter string 2:");
        String str2 = br.readLine().trim();

        int out = solution(str1, str2);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.equals(str2)) {
            return 0;
        }

        int output = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) < str2.charAt(i)) {
                output = -1;
                break;
            } else if(str1.charAt(i) > str2.charAt(i)) {
                output = 1;
                break;
            }
        }
        return output;
    }

}
