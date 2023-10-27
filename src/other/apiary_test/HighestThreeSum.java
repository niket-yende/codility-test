package other.apiary_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to find the sum of subset of highest 3 elements of an array.
 *
 * Input: [4, 10, 5, 8, 10, 0, 1, 2]
 * Output:
 * firstHighest: 10, index: 1
 * secondHighest: 10, index: 4
 * thirdHighest: 8, index: 3
 */
public class HighestThreeSum {
    public static void main(String[] args) {
        int[] a = {4, 10, 5, 8, 10, 0, 1, 2};
        solution(a);
    }

    static void solution(int[] array) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArray);

        int firstHighest = tempArray[tempArray.length - 1];
        int secondHighest = tempArray[tempArray.length - 2];
        int thirdHighest = tempArray[tempArray.length - 3];

        List<Integer> indexList = new ArrayList<>();
        System.out.println("firstHighest: "+firstHighest+", index: "+findIndex(array, indexList, firstHighest));
        System.out.println("secondHighest: "+secondHighest+", index: "+findIndex(array, indexList, secondHighest));
        System.out.println("thirdHighest: "+thirdHighest+", index: "+findIndex(array, indexList, thirdHighest));
    }

    static int findIndex(int[] array, List<Integer> indexList, int value) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(!indexList.contains(i) && value == array[i]) {
                indexList.add(i);
                index = i;
                break;
            }
        }
        return index;
    }
}
