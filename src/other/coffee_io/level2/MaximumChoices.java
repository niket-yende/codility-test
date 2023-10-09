package other.coffee_io.level2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to find the max choices
 * Input:
 * n: 3 (types of ice creams)
 * arr: 1 2 3 (prices of ice creams)
 * x: 4 (max balance)
 * Output: 2
 */
public class MaximumChoices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        System.out.println(solution(array, n, x));
    }

    static int solution(int[] array, int n, int x) {
        int balance = x;
        Arrays.sort(array);
        int i = 0;

        while(balance > 0) {
            balance = balance - array[i];
            if(balance < 0) {
                break;
            }
            i++;
        }

        return i;
    }
}
