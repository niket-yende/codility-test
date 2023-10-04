package other.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Check if two string are rotation of each other
 * Input A: hello
 * Input B: lohel
 * Output: true
 */
public class StringRotationChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter string A:");
        String inputA = br.readLine().trim();

        System.out.println("Enter string B:");
        String inputB = br.readLine().trim();

        boolean output = areRotations(inputA, inputB);
        System.out.println(output);

        wr.close();
        br.close();
    }

    static boolean areRotations(String inputA, String inputB) {
        if(inputA.length() != inputB.length()) {
            return false;
        }

        String concatenatedStr = inputA + inputA;

        // Check if inputB is a substring of concatenatedStr
        if(concatenatedStr.contains(inputB)) {
            return true;
        }
        return false;
    }
}
