package lessons.euclidean_algorithm.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Check whether two numbers have the same prime divisors.
 * Reference: https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
 */
public class CommonPrimeDivisors {
    public static void main(String[] args) {
        int[] a = {15, 10, 3};
        int[] b = {75, 30, 5};

        int out = solution(a, b);
        System.out.println(out);
    }

    static int solution(int[] a, int[] b) {
        int commonDivisorCount = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int nValue = a[i];
            int mValue = b[i];

            // Divisors for nValue part of array A
            List<Integer> aDivisors = findPrimeDivisors(nValue);

            // Divisors for nValue part of array B
            List<Integer> bDivisors = findPrimeDivisors(mValue);

            if(aDivisors.equals(bDivisors)) {
                commonDivisorCount++;
            }
        }


        return commonDivisorCount;
    }

    static List<Integer> findPrimeDivisors(int value) {
        List<Integer> primeList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        List<Integer> divisorList = new ArrayList<>();

        for (Integer primeNumber: primeList) {
            // Value should be fully divisible by prime number
            if(value % primeNumber == 0) {
                divisorList.add(primeNumber);
            }
        }

        return divisorList;
    }
}
