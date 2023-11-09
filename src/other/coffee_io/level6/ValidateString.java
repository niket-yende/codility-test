package other.coffee_io.level6;

import java.util.Scanner;
import java.util.Stack;

/**
 * Program to validate parenthesis sequence.
 * Input:
 * 16
 * (()*))*)**))*)(*
 * Output:
 * true
 *
 * Input:
 * 30
 * ))(*((********)(*))()()((*)*(*
 * Output:
 * false
 */
public class ValidateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(str, n));
    }

    static String solution(String s, int n) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return "false";
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return "false";
            }
        }

        return leftStack.isEmpty() ? "true" : "false";
    }
}
