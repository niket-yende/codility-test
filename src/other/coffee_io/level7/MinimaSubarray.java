package other.coffee_io.level7;

import java.util.Scanner;
import java.util.Stack;

/**
 * Program to find sum of minimum elements of every subarray of arr.
 * Input:
 * 4
 * 3 1 2 4
 * Output:
 * 17
 * Input:
 * 5
 * 11 81 94 43 3
 * Output:
 * 444
 */
public class MinimaSubarray {
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
        final int MOD = 1000000007;
        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || a[i] < a[stack.peek()])) {
                int poppedIndex = stack.pop();
                long min = a[poppedIndex];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                result = (result + min * (i - poppedIndex) * (poppedIndex - leftBoundary)) % MOD;
            }
            stack.push(i);
        }

        return (int) result;
    }
}
