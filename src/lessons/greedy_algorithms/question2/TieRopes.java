package lessons.greedy_algorithms.question2;

/**
 * Tie adjacent ropes to achieve the maximum number of ropes of length >= K.
 * Reference: https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
 */
public class TieRopes {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 1, 3};
        int k = 4;

        int out = solution(k, array);
        System.out.println(out);
    }

    static int solution(int k, int[] array) {
        int maxRopes = 0;

        int currentLength = 0;
        for (int i = 0; i < array.length; i++) {
            currentLength = currentLength + array[i];
            if(currentLength >= k) {
                currentLength = 0;
                maxRopes++;
            }
        }

        return maxRopes;
    }
}
