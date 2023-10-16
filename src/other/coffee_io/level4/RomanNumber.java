package other.coffee_io.level4;

import java.util.Scanner;

/**
 * Program to print roman number for n.3
 * Input: 3
 * Output: III
 */
public class RomanNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    static String solution(int n) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        int i = 0;
        while (n > 0) {
            while (n >= values[i]) {
                roman.append(numerals[i]);
                n -= values[i];
            }
            i++;
        }
        return roman.toString();
    }
}
