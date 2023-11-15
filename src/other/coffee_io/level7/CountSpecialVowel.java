package other.coffee_io.level7;

import java.util.Scanner;

/**
 * Program to count special vowel strings.
 * Input:
 * 2
 * Output:
 * 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa", "ae", "ai", "ao", "au", "ee", "ei", "eo", "eu", "ii", "io", "iu", "oo", "ou", "uu"]
 */
public class CountSpecialVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    static int solution(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        return generateStrings("", 0, n, vowels);
    }

    static int generateStrings(String current, int index, int n, char[] vowels) {
        if(index == n) {
            return 1;
        }

        int count = 0;
        for(char vowel : vowels) {
            if(current.isEmpty() || vowel >= current.charAt(current.length() - 1)) {
                count += generateStrings(current + vowel, index + 1, n, vowels);
            }
        }
        return count;
    }


}
