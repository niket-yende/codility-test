package lessons.fibonacci_numbers.question2;

import java.util.Arrays;

/**
 * Count the number of different ways of climbing to the top of a ladder.
 * Reference: https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
 *            https://github.com/Mickey0521/Codility/blob/master/Ladder.java
 */
public class Ladder {
    public static void main(String[] args) {
        int[] a = {4, 4, 5, 5, 1};
        int[] b = {3, 2, 4, 3, 1};

        int[] out = solution(a, b);
        System.out.println(Arrays.toString(out));
    }

    static int[] solution(int[] a, int[] b) {
        // The task is to find out the number of ways
        // someone can climb up a ladder of N rungs
        // by ascending one or two rungs at a time.
        // It is not very hard to see that
        // this number is just the "Fibonacci number of order N"

        // we implemented an easy dynamic programming approach
        // to compute Fibonacci numbers, this will take complexity O(n)

        // I use binary operators to keep track of "N modulo 2^{30}"
        // otherwise. the Fibonacci numbers will cause a memory overflow (be careful~!!)
        // and we are also asked to return "numbers modulo some power of 2"

        int length = a.length;

        // determine the "max" for Fibonacci
        int max = Arrays.stream(a).max().getAsInt();

        //max += 2; // for Fibonacci
        int[] fibonacci = new int[max+1]; // plus one for "0"

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i=2; i <= max; i++){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % (1 << 30);
            // we want to find the result of "a number modulo 2^P"
            // if we first let the number modulo 2^Q (Q > P)
            // then, modulo 2^P, the esult is the same.
            // So, "we first modulo 2^30" to avoid overflow
            // where, 2^30 == 1 << 30
        }

        // to find "results"
        int[] results = new int[length];

        for(int i=0; i < length; i++){
//            results[i] = fibonacci[a[i]] % (1 << b[i]); // where, "1 << b[i]" means 2^b[i]
            int moduloValue = (int) Math.pow(2, b[i]);
            results[i] = fibonacci[a[i]] % moduloValue;
        }

        return results;
    }
}
