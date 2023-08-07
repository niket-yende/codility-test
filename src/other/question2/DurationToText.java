package other.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DurationToText {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        int seconds = Integer.parseInt(br.readLine().trim());

        String out_ = solution(seconds);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static String solution(int seconds) {
        StringBuffer result = new StringBuffer();

        if(seconds == 0) {
            return "now";
        }

        String[] units = {"year", "day", "hour", "minute", "second"};
        int[] duration = {365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1};
        int count = 0;

        for(int i = 0; i < units.length; i++) {
            if(seconds > duration[i]) {
                count = seconds / duration[i];
                result.append(count).append(" ").append(units[i]).append(count > 1 ? "s" : "").append(", ");
                seconds = seconds % duration[i];
            }
        }

        if(result.length() > 0) {
            // Removing the trailing comma
            result.setLength(result.length() - 2);
            int lastCommaIndex = result.lastIndexOf(",");
            if(lastCommaIndex != -1) {
                result.replace(lastCommaIndex, lastCommaIndex + 1, " and");
            }
        }

        return result.toString();
    }
}
