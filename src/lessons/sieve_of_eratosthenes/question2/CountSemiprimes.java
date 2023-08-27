package lessons.sieve_of_eratosthenes.question2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Count the semiprime numbers in the given range [a..b]
 * Reference: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
 */
public class CountSemiprimes {
    public static void main(String[] args) {
        int n = 26;
        int[] p = {1, 4, 16};
        int[] q = {26, 10, 20};

        int[] out = solution(n, p, q);
        System.out.println(Arrays.toString(out));
    }

    static int[] solution(int n, int[] p, int[] q) {
        int length = p.length;
        int[] outArray = new int[length];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> primeArray = new ArrayList<>();

        // Find all the prime no. till n
        for (int i = 2; i <= n; i++) {
            if(isPrimeNumber(i)) {
                primeArray.add(i);
            }
        }

        // Find all semiprime numbers
        Set<Integer> semiPrimeSet = new HashSet<>();
        for (int l = 0; l < primeArray.size(); l++) {
            for (int k = l; k < primeArray.size(); k++) {
                int product = primeArray.get(l) * primeArray.get(k);
                if(!semiPrimeSet.contains(product) && product <= n) {
                    semiPrimeSet.add(product);
                } else {
                    break;
                }
            }
        }

        // Count the semiprime no.s for a range
        for (int j = 0; j < length; j++) {
            List<Integer> subList = findSubList(semiPrimeSet, p[j], q[j]);
            outArray[j] = subList.size();
        }

        return outArray;
    }

    static boolean isPrimeNumber(int num) {
        if(num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    static List<Integer> findSubList(Set<Integer> semiPrimeSet, int startValue, int endValue) {
        return semiPrimeSet.stream().filter(ele -> (ele >= startValue && ele <= endValue)).collect(Collectors.toList());
    }
}
