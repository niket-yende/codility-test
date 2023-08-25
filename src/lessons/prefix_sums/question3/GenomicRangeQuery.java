package lessons.prefix_sums.question3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find the minimal nucleotide from a range of sequence DNA.
 * Reference: https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */
public class GenomicRangeQuery {
    public static void main(String[] args) {

        String s = "CAGCCTA";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};

        int[] out = solution(s, p, q);
        System.out.println(Arrays.toString(out));
    }

    static int[] solution(String s, int[] p, int[] q) {
        int[] output = new int[p.length];

        char[] characters = s.toCharArray();

        Map<Character, Integer> impactFactorMap = new HashMap<>();
        impactFactorMap.put('A', 1);
        impactFactorMap.put('C', 2);
        impactFactorMap.put('G', 3);
        impactFactorMap.put('T', 4);

        for (int i = 0; i < p.length; i++) {
            int startIndex = p[i];
            int endIndex = q[i] == characters.length - 1 ? q[i] : q[i] + 1;
            int minImpact = Integer.MAX_VALUE;
            for (int j = startIndex; j < endIndex; j++) {
                char currentChar = characters[j];
                Integer currentImpact = impactFactorMap.get(currentChar);
                minImpact = Math.min(minImpact, currentImpact);
            }
            output[i] = minImpact;
        }

        return output;
    }
}
