package lessons.stacks_and_queues.question2;

import java.util.Stack;

/**
 * N voracious fish are moving along a river. Calculate how many fish are alive.
 * Reference: https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 */
public class Fish {
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1, 5};
        int[] b = {0, 1, 0, 0, 0};

        int out = solution(a, b);
        System.out.println(out);
    }

    static int solution(int[] a, int[] b) {
        if(a.length == 0) {
            return 0;
        }

        int aliveFish = a.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            // Case 1: Handle downstream fish
            if(b[i] == 1) {
                stack.push(a[i]);
            } else if (b[i] == 0) {
                // Case 2: Handle upstream fish
                if(!stack.isEmpty()) {
                    Integer peekedFish = stack.peek();
                    if(peekedFish > a[i]) {
                        aliveFish--;
                    } else if(peekedFish < a[i]) {
                        aliveFish--;
                        stack.pop();
                    }
                }
            }
        }


        return aliveFish;
    }
}
