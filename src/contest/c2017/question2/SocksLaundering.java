package contest.c2017.question2;

import java.io.IOException;
import java.util.*;

public class SocksLaundering {
    public static void main(String[] args) throws IOException {
        int k = 2;
        Integer[] c = {1, 2, 1, 1};
        Integer[] d = {1, 4, 3, 2, 4};

        int out = solution(k, c, d);
        System.out.println(out);
    }

    static int solution(int k, Integer[] c, Integer[] d){
        int output = 0;
        List<Integer> cleanList = new ArrayList<>(Arrays.asList(c));

        for (int i = 0; i < d.length; i++) {
            int index = i;
            long count = cleanList.stream().filter(ele -> ele == d[index]).count();
            if(k > 0 && count % 2 > 0) {
                cleanList.add(Integer.valueOf(d[index]));
                // Subtract this sock from k
                k -= 1;
            } else if(k == 0) {
                break;
            }
        }

        Set<Integer> cleanSockSet = new HashSet<>(cleanList);

        // This is added since sock color from clean list might not present in dirty list
        for (Integer sock: cleanSockSet) {
            int frequency = Collections.frequency(cleanList, sock);
            int availableCleanPairs = Math.toIntExact(frequency / 2);
            if(availableCleanPairs > 0) {
                output += availableCleanPairs;
            }
        }

        return output;
    }
}
