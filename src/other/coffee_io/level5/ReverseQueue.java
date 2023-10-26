package other.coffee_io.level5;

import java.util.*;

/**
 * Write a program to reverse k elements of a queue.
 * Input:
 * 5 3
 * 1 2 3 4 5
 * Output:
 * 3 2 1 4 5
 */
public class ReverseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        solution(a, n, k);
    }

    static void solution(int[] a, int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < n; j++) {
            int element = a[j];
            queue.add(element);
            if(j < k) {
                stack.push(element);
            }
        }

        Queue<Integer> newQueue = new LinkedList<>();
        while (!stack.isEmpty()) {
            newQueue.add(stack.peek());
            stack.pop();
        }

        for (int i = k; i < n; i++) {
            newQueue.add(a[i]);
        }

        int m = 0;
        while(!newQueue.isEmpty()) {
            int element = newQueue.peek();
            System.out.print(element);
            if(m < n - 1) {
                System.out.print(" ");
            }
            newQueue.remove();
            m++;
        }
    }
}
