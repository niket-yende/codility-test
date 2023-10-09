package other.coffee_io.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class FirstUniqueCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter input string s:");
        String s = br.readLine().trim();

        int out = solution(s);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(String s) {
        int index = -1;
        Map<Character, Boolean> visitMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(!visitMap.containsKey(currentChar)) {
                visitMap.put(currentChar, true);
                int frequency = Collections.frequency(Arrays.asList(s.split("")), String.valueOf(currentChar));
                if(frequency == 1) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }
}
