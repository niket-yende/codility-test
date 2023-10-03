package other.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Program to check if a string is an anagram
 * InputA: !low-salt!
 * InputB: owls-lat!!
 * Output: true
 */
public class StringAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter first string:");
        String inputA = br.readLine().trim();

        System.out.println("Enter second string:");
        String inputB = br.readLine().trim();

        boolean output = solution(inputA, inputB);
        System.out.println(output);

        wr.close();
        br.close();
    }

    static boolean solution(String stringA, String stringB) {
        if(stringA.length() != stringB.length()) {
            return false;
        }

        char[] a = stringA.toCharArray();
        char[] b = stringB.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
