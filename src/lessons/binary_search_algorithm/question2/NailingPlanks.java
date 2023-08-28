package lessons.binary_search_algorithm.question2;

/**
 * Count the minimum number of nails that allow a series of planks to be nailed.
 * Reference: https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
 */
public class NailingPlanks {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 8};
        int[] b = {4, 5, 9, 10};
        int[] c = {4, 6, 7, 10, 2};

        int out = solution(a, b, c);
        System.out.println(out);
    }

    static int solution(int[] a, int[] b, int[] c) {
        int n = a.length;
        int m = c.length;
        int minNails = 1;
        int maxNails = m;
        int result = -1;

        while (minNails <= maxNails) {
            int midNails = (minNails + maxNails) / 2;
            int[] nails = new int[2 * m + 1];

            // Mark the positions of the nails that are used
            for (int i = 0; i < midNails; i++) {
                nails[c[i]] = 1;
            }

            // Calculate the prefix sum of nails
            for (int i = 1; i < nails.length; i++) {
                nails[i] += nails[i - 1];
            }

            boolean allPlanksNailed = true;

            // Check if all planks can be nailed
            for (int i = 0; i < n; i++) {
                if (nails[b[i]] - nails[a[i] - 1] == 0) {
                    allPlanksNailed = false;
                    break;
                }
            }

            if (allPlanksNailed) {
                result = midNails;
                maxNails = midNails - 1;
            } else {
                minNails = midNails + 1;
            }
        }

        return result;
    }
}
