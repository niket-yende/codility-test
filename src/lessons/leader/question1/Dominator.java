package lessons.leader.question1;

import java.util.*;

/**
 * Find an index of an array such that its value occurs at more than half of indices in the array.
 * Reference: https://app.codility.com/programmers/lessons/8-leader/dominator/
 */
public class Dominator {
    public static void main(String[] args) {
        int[] array = {3, 4, 3, 2, 3, -1, 3, 3};
        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        int dominationFactor = array.length / 2;
        int dominator = 0;
        int dominatorIndex = -1;
        Map<Integer, Integer> countMap = new HashMap<>();

        // Counting occurrence of each element
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            int count = 1;
            if(countMap.containsKey(element)) {
                int existingCount = countMap.get(element);
                count = existingCount + 1;
            }
            countMap.put(element, count);
        }

        // Find the dominator index
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < array.length; j++) {
            int element = array[j];
            if(!set.contains(element)) {
                int elementCount = countMap.get(element);
                if(elementCount > dominationFactor) {
                    dominator = element;
                    dominatorIndex = j;
                    break;
                }
            } else {
                set.add(element);
            }
        }

        System.out.println("Dominator: "+dominator);
        System.out.println("Dominator index: "+dominatorIndex);

        return dominatorIndex;
    }
}
