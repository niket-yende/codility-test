package algorithm_skills.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class FirstUnique {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter number of elements of array:");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Elements:");
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        int out = solution(array);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static int solution(Integer[] array) {
        int uniqueNum = -1;
        List<Integer> dataList = new ArrayList<>(Arrays.asList(array));
        Set<Integer> dataSet = new LinkedHashSet<>(dataList);

        for (Integer num: dataSet) {
            if(Collections.frequency(dataList, num) == 1){
                uniqueNum = num;
                break;
            }
        }

        return uniqueNum;
    }
}
