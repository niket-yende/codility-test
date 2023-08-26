package lessons.stacks_and_queues.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Determine whether a given string of parentheses (single type) is properly nested.
 * Reference: https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 */
public class Nesting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter string S:");
        String s = br.readLine().trim();

        int out = solution(s);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(String s) {
        if(s.length() == 0) {
            return 1;
        } else if (s.length() % 2 == 1) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(currentChar == '(') {
                stack.push(')');
            } else {
                if(stack.isEmpty()) {
                    return 0;
                } else {
                    char poppedChar = stack.pop();
                    if(poppedChar != currentChar) {
                        return 0;
                    }
                }
            }

        }

        if(!stack.isEmpty())
            return 0;

        return 1;
    }
}
