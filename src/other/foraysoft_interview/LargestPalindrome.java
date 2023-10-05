package other.foraysoft_interview;

/**
 * Program to find largest palindrome in a string
 *
 * Reference: https://www.digitalocean.com/community/tutorials/longest-palindrome-substring-string-java
 * Input: 4312321456
 * Output: 12321
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        String s = "4312321456";
        System.out.println(longestPalindromeString(s));
    }

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // O(n^2)
    public static String longestPalindromeString(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindrome = intermediatePalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }
}
