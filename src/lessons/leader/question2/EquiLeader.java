package lessons.leader.question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 * Reference: https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 *            https://github.com/Mickey0521/Codility/blob/master/EquiLeader.java
 */
public class EquiLeader {
    public static void main(String[] args) {
        int[] array = {4, 3, 4, 4, 4, 2};
        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();

        if( array.length == 0)
            return 0;

        // Counting occurrence of each element
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            int count = 1;
            if(countMap.containsKey(element)) {
                int existingCount = countMap.get(element);
                count = existingCount + 1;
            }
            countMap.put(element, count);
        }

        // check "if there is a leader"
        int leaderValue = 0;
        int leaderCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < array.length; j++) {
            int element = array[j];
            if(!set.contains(element)) {
                int elementCount = countMap.get(element);
                if(elementCount > (array.length * 0.5)) {
                    leaderValue = element;
                    leaderCount = elementCount;
                    break;
                }
            } else {
                set.add(element);
            }
        }

        // No leader value found
        if(leaderValue == 0) {
            return 0;
        }

        int numEquileaders = 0; // number of equi leaders
        int leftLeaderCount =0; // number of leaders in left side

        // scan the array
        for(int i=0; i<array.length; i++){
            // find a leader (in left side)
            if(array[i] == leaderValue){
                leftLeaderCount++;
            }

            // if the leader is "a leader in left side" (more than half)
            if( leftLeaderCount > (0.5) * (i+1) ){
                // then, check right side
                int rightLeaderCount = leaderCount - leftLeaderCount;
                // if the leader is "a leader in right side" (more than half)
                if( rightLeaderCount > (0.5) * (array.length -i -1) ){
                    numEquileaders++; // leader in both sides (then, equi leaders++)
                }
            }
        }

        return numEquileaders;
    }

}
