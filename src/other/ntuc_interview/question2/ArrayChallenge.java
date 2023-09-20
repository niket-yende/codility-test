package other.ntuc_interview.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Write a program to push the latest occurrence of a character to latest and remove the previous occurrence.
 * Also add hyphen between the characters. Once your function is working, take the final output string and concatenate it with your challengeToken,
 * and then replace every fourth character with an underscore.
 * Input: A B C B C A
 * Output: B-C_Ata_gzk_26
 */
public class ArrayChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter elements:");
        String[] input = br.readLine().trim().split(" ");

        String output = solution(input);
        System.out.println(output);

        wr.close();
        br.close();
    }

    static String solution(String[] strArray) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < strArray.length; i++) {
            String element = strArray[i];

            if(list.contains(element)) {
                list.remove(element);
            }
            list.add(element);
        }

        String challengeToken = "taqgzk826";
        String output = addHyphen(list) + challengeToken;
        System.out.println("output: "+output);

        return printFinalOut(output);
    }

    static String addHyphen(List<String> input) {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner("-");
        for (String item: input) {
            sj.add(item);
        }

        String out = sj.toString();

        return out;
    }

    static String printFinalOut(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if((i+1) % 4 == 0) {
                sb.append("_");
            } else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }
}
