package other.ntuc_interview.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem to find the value of stringified expression
 */
public class StringChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter input string:");
        String str = br.readLine().trim();

        String out = solution(str);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static String solution(String str) {
        String output = "Invalid number";

        String tempStr = str.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replace("plus", "+")
                .replace("minus", "-");


        // evaluate the expression
        String result = evaluateExpression(tempStr);
        System.out.println("result: "+ result);

        String challengeToken = "taqgzk826";
        output = result + challengeToken;

        return printFinalOut(output);
    }

    static String evaluateExpression(String input) {
        String leftSide = "";
        String rightSide = "";
        String operator = "";
        List<String> operatorList = Arrays.asList("+", "-");
        boolean foundOperator = false;
        int operatorCount = 0;

        System.out.println("input: "+input);

        for(int i = 0; i < input.length(); i++) {
            String element = Character.toString(input.charAt(i));

            if(operatorList.contains(element)) {
                if(operatorCount > 0) {
                    int out = processExpression(leftSide, rightSide, operator);
                    leftSide = String.valueOf(out);
                    // Reset the rightSide
                    rightSide = "";
                }
                operator = element;
                foundOperator = true;
                operatorCount++;
            } else if(foundOperator) { // right value
                rightSide += element;
            } else {
                leftSide += element;
            }
        }

        int result = processExpression(leftSide, rightSide, operator);

        return convertToString(result);
    }

    static String convertToString(int result) {
        String temp = String.valueOf(result);

        temp = temp.replace("0","zero")
                .replace("1","one")
                .replace("2", "two")
                .replace("3", "three")
                .replace("4", "four")
                .replace("5", "five")
                .replace("6", "six")
                .replace("7", "seven")
                .replace("8", "eight")
                .replace("9", "nine")
                .replace("-", "negative");

        return temp;
    }

    static int processExpression(String leftSide, String rightSide, String operator) {
        int output = 0;

        int leftValue = Integer.parseInt(leftSide);
        int rightValue = Integer.parseInt(rightSide);

        if(operator.equals("+")) {
            output = leftValue + rightValue;
        } else if(operator.equals("-")) {
            output = leftValue - rightValue;
        }

        return output;
    }

    static String printFinalOut(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if((i+1) % 4 == 0) {
                sb.append("_");
            } else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }
}
