package other.coffee_io.level7;

import java.util.Scanner;
import java.util.Stack;

/**
 * Program to find the largest area.
 * Input:
 * 6
 * 2 1 5 6 2 3
 * Output:
 * 10
 */
public class LargestArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = solution(a, n);
        System.out.println(ans);
    }

    static int solution(int[] a, int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] + 1;
            int area = width * a[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
