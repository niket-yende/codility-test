package lessons.prefix_sums.question4;

/**
 * Find the minimal average of any slice containing at least two elements.
 * Reference: https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 *            https://github.com/Mickey0521/Codility/blob/master/MinAvgTwoSlice.java
 */
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 5, 1, 5, 8};
        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        float min = Integer.MAX_VALUE;
        int min_start_position = 0;

        for(int i=0; i< array.length - 2; i++){
            float avg_2 = (float) (array[i]+array[i+1])/2;         // avg of length of 2
            float avg_3 = (float) (array[i]+array[i+1]+array[i+2])/3;  // avg of length of 3

            float cur_min_avg = Math.min(avg_2, avg_3);

            if(cur_min_avg < min){
                min = cur_min_avg;
                min_start_position = i;
            }
        }

        // Corner case: find the avg of last 2 elements
        int avg_2 = (array[array.length-2]+array[array.length-1]) / 2;
        if( avg_2 < min){
            min = avg_2;
            min_start_position = array.length-2;
        }

        return min_start_position;
    }
}
