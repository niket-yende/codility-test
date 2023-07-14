package contest.c2015.medium;

import java.util.Stack;

/**
 * Reference: https://massivealgorithms.blogspot.com/2016/12/flood-depth-codility.html
 */
public class MaximumWaterDepth {
    public static int getMaxWaterDepth(int[] array) {
        int highestIdx = 0;
        int lowestIdx = 0;
        int max = 0;

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int highest = array[highestIdx];
            int lowest = array[lowestIdx];
            if (current > highest) {
                max = Math.max(highest - lowest, max);
                highestIdx = i;
                lowestIdx = highestIdx;
            } else if (current > lowest) {
                max = Math.max(current - lowest, max);
            } else if (current < lowest) {
                lowestIdx = i;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        int maxDepth = getMaxWaterDepth(array);
        System.out.println("Maximum water depth: " + maxDepth);
    }
}
