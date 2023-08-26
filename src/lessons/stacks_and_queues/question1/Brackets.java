package lessons.stacks_and_queues.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Determine whether a given string of parentheses (multiple types) is properly nested.
 * Reference: https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 *            https://github.com/Mickey0521/Codility/blob/master/Brackets.java
 */
public class Brackets {
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
        Stack<Character> stack = new Stack<>();

        if(s.isEmpty()) {
            return 1;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '{') {
                stack.push('}');
            } else if(currentChar == '[') {
                stack.push(']');
            } else if(currentChar == '(') {
                stack.push(')');
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
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

        if(!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }
}
