package contest.c2015.easy;

public class LongestPassword {
    public boolean validPassword(String password) {
        int letterCount = password.replaceAll("[^a-zA-Z]", "").length();
        int numericCount = password.replaceAll("[^0-9]", "").length();
        return password != null
                && password.matches("^[a-zA-Z0-9]*$")
                && letterCount % 2 == 0
                && numericCount % 2 != 0;
    }

    public int solution(String s) {
        String[] words = s.trim().split(" ");
        int longestPassword = -1;
        for(String word: words) {
            if(validPassword(word)) {
                int currentWordLength = word.length();
                longestPassword = currentWordLength > longestPassword ? currentWordLength : longestPassword;
            }
        }
        return longestPassword;
    }

    public static void main(String[] args) {
        String input = "test 5 a0A pass007 ?xy1 ac111bd2";
        LongestPassword lp = new LongestPassword();
        int longestValidPassword = lp.solution(input);
        System.out.println(longestValidPassword);
    }
}
