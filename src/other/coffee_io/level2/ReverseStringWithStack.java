package other.coffee_io.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class ReverseStringWithStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter input string:");
        String s = br.readLine().trim();

        String reversed = solution(s);
        System.out.println(reversed);

        wr.close();
        br.close();
    }

    static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while(!stack.isEmpty()) {
            Character c = stack.peek();
            sb.append(c);
            stack.pop();
        }

        return sb.toString();
    }
}
