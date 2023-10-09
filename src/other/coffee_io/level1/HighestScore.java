package other.coffee_io.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Program to find the highest score of the candidate
 *
 * Input:
 * n: 9
 * s: AAAABBBBB
 *
 * Output:
 * Max correct answers: 4
 * Akbar
 * Amar
 * Anthony
 */
public class HighestScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter N:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter correct answers:");
        String s = br.readLine().trim();

        solution(s, n);

        wr.close();
        br.close();
    }

    static void solution(String s, int n) {
        String amarAnswers = getAnswerString("ABC", n);
        String akbarAnswers = getAnswerString("BABC", n);
        String anthonyAnswers = getAnswerString("CCAABB", n);
        Map<String, Integer> correctAnswerMap = new HashMap<>();
        int maxCorrectAnswers = 0;

        for (int i = 0; i < n; i++) {
            char currentAnswer = s.charAt(i);

            if(amarAnswers.charAt(i) == currentAnswer) {
                int answerCount = 1;
                if(correctAnswerMap.containsKey("Amar")) {
                    answerCount = correctAnswerMap.get("Amar") + 1;
                }
                correctAnswerMap.put("Amar", answerCount);
                if(maxCorrectAnswers < answerCount) {
                    maxCorrectAnswers++;
                }
            }
            if(akbarAnswers.charAt(i) == currentAnswer) {
                int answerCount = 1;
                if(correctAnswerMap.containsKey("Akbar")) {
                    answerCount = correctAnswerMap.get("Akbar") + 1;
                }
                correctAnswerMap.put("Akbar", answerCount);
                if(maxCorrectAnswers < answerCount) {
                    maxCorrectAnswers++;
                }
            }
            if(anthonyAnswers.charAt(i) == currentAnswer) {
                int answerCount = 1;
                if(correctAnswerMap.containsKey("Anthony")) {
                    answerCount = correctAnswerMap.get("Anthony") + 1;
                }
                correctAnswerMap.put("Anthony", answerCount);
                if(maxCorrectAnswers < answerCount) {
                    maxCorrectAnswers++;
                }
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(correctAnswerMap);

        System.out.println("Max correct answers: "+maxCorrectAnswers);
        for (Map.Entry<String, Integer> element: sortedMap.entrySet()) {
            if(element.getValue() == maxCorrectAnswers) {
                System.out.println(element.getKey());
            }
        }
    }

    static String getAnswerString(String sequence, int n) {
        StringBuffer sb = new StringBuffer();

        while(sb.length() <= n) {
            sb.append(sequence);
        }

        return sb.substring(0, n);
    }
}
