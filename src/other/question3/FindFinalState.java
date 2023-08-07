package other.question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindFinalState {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

//        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_actions = br.readLine().split(" ");

        String out_ = solution(arr_actions);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static String solution(String[] events) {
        String result = "";
        String currentState = "CLOSED";

        Map<String, Map<String, String>> transitions = getEventTransitions();

        for (String event : events) {
            boolean foundEvent = false;
            for (Map.Entry<String, Map<String, String>> entry : transitions.entrySet()) {
                String key = entry.getKey();
                Map<String, String> valueMap = entry.getValue();
                // Check if the transition of event is correct
                if(valueMap.containsKey(event) && key.equals(currentState)) {
                    foundEvent = true;
                    currentState = transitions.get(key).get(event);
                    break;
                }
            }
            if(!foundEvent) {
                result = "ERROR";
                break;
            }
        }

        return result;
    }

    static Map<String, Map<String, String>>  getEventTransitions() {
        Map<String, Map<String, String>> transitions = new HashMap<>();
        // Define the transitions based on the given actions
        transitions.put("CLOSED", Map.of(
                "APP_PASSIVE_OPEN", "LISTEN",
                "APP_ACTIVE_OPEN", "SYN_SENT"
        ));
        transitions.put("LISTEN", Map.of(
                "RCV_SYN", "SYN_RCVD",
                "APP_SEND", "SYN_SENT",
                "APP_CLOSE", "CLOSED"
        ));
        transitions.put("SYN_RCVD", Map.of(
                "APP_CLOSE", "FIN_WAIT_1",
                "RCV_ACK", "ESTABLISHED"
        ));
        transitions.put("SYN_SENT", Map.of(
                "RCV_SYN", "SYN_RCVD",
                "RCV_SYN_ACK", "ESTABLISHED",
                "APP_CLOSE", "CLOSED"
        ));
        transitions.put("ESTABLISHED", Map.of(
                "APP_CLOSE", "FIN_WAIT_1",
                "RCV_FIN", "CLOSE_WAIT"
        ));
        transitions.put("FIN_WAIT_1", Map.of(
                "RCV_FIN", "CLOSING",
                "RCV_FIN_ACK", "TIME_WAIT",
                "RCV_ACK", "FIN_WAIT_2"
        ));
        transitions.put("CLOSING", Map.of(
                "RCV_ACK", "TIME_WAIT"
        ));
        transitions.put("FIN_WAIT_2", Map.of(
                "RCV_FIN", "TIME_WAIT"
        ));
        transitions.put("TIME_WAIT", Map.of(
                "APP_TIMEOUT", "CLOSED"
        ));
        transitions.put("CLOSE_WAIT", Map.of(
                "APP_CLOSE", "LAST_ACK"
        ));
        transitions.put("LAST_ACK", Map.of(
                "RCVACK", "CLOSED"
        ));
        return transitions;
    }
}
