package other.coffee_io.level6;

import java.util.*;

/**
 * Program to find distinct common elements.
 * Input 1:
 * 4
 * 2 1 4 3 1 2 3 2 3 6 2 3 5 2 5 3
 * Output 1:
 * 2
 * Input 2:
 * 5
 * 12 1 14 3 16 14 2 1 3 35 14 1 14 3 11 14 5 3 2 1 1 18 3 21 14
 * Output 2:
 * 3
 */
public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(arr, n));
    }

    static int solution1(int[][] arr, int n) {
        List<Integer> firstRow = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            firstRow.add(arr[0][i]);
        }

        // find common elements
        for (int j = 1; j < n; j++) {
            Set<Integer> commonSet = new HashSet<>();
            for (int k = 0; k < n; k++) {
                int currentElement = arr[j][k];
                if(firstRow.contains(currentElement)) {
                    commonSet.add(currentElement);
                }
            }
            if(commonSet.size() > 0) {
                list.addAll(commonSet);
            }
        }

        int count = 0;
        for (Integer element: firstRow) {
            int frequency = Collections.frequency(list, element);
            if(frequency == n - 1) {
                count++;
            }
        }


        return count;
    }

    static int solution(int[][] arr, int n) {
        Set<Integer> prevSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            prevSet.add(arr[0][i]);
        }
        
        // find common elements
        for (int j = 1; j < n; j++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int k = 0; k < n; k++) {
                int currentElement = arr[j][k];
                if(prevSet.contains(currentElement)) {
                    currentSet.add(currentElement);
                }
            }
            // Reset the prev set
            prevSet = currentSet;
            if(prevSet.size() == 0) {
                break;
            }
        }

        return prevSet.size();
    }
}
