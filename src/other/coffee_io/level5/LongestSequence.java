package other.coffee_io.level5;

import java.util.*;

/**
 * Program to find the longest special subsequence of the array such that
 * absolute difference b/w every adjacent element in the sub-sequence is one.
 */
public class LongestSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = solution(a, n);
        System.out.println(ans);
    }

    static int solution1(int[] a, int n) {
        List<Integer> longestSubSequence = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> subSequence = new ArrayList<>();
            subSequence.add(a[i]);
            int remainingElements = (a.length - 1) - i;
            if(remainingElements <= longestSubSequence.size()) {
                break;
            }
            for (int j = i+1; j < a.length; j++) {
                Integer lastElement = subSequence.get(subSequence.size() - 1);
                Integer difference = findDifference(lastElement, a[j]);
                if(difference == 1) {
                    subSequence.add(a[j]);
                }
            }

            if(subSequence.size() > longestSubSequence.size()) {
                longestSubSequence = subSequence;
            }
        }

        return longestSubSequence.size() > 1 ? longestSubSequence.size() : 0;
    }

    static int solution(int[] a, int n) {
        int[] dp = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Math.abs(a[i] - a[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    static int findDifference(int x, int y) {
        int difference = x - y;
        return Math.abs(difference);
    }
}
