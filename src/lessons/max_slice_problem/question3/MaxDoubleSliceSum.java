package lessons.max_slice_problem.question3;

/**
 * Find the maximal sum of any double slice.
 * Reference: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 *            https://github.com/Mickey0521/Codility/blob/master/MaxDoubleSliceSum.java
 */
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] array = {3, 2, 6, -1, 4, 5, -1, 2};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        // (X, Y, Z)
        // 1st slice: array[X+1] + ... + array[Y-1]
        // 2nd slice: array[Y+1] + ... + array[Z-1]
        // Key Point:
        // The array will be split at "Y"

        // main idea:
        // if the middle point is "Y",
        // find "maxLeft" and "maxRight"

        int maxLeft[] = new int[array.length];
        int maxRight[] = new int[array.length];

        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i
        // note: because it is "contiguous", we only need the ending index (important)
        for(int i = 1; i < array.length ; i++){   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = Math.max(0, maxLeft[i-1]+array[i] ); //golden slice algorithm: Math.max(0, maxLeft[i-1]+array[i] )
        }

        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i
        // note: because it is "contiguous", we only need the starting index (important)
        for(int i = array.length-2; i >= 0; i--){   // be careful: from i=array.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(0, maxRight[i+1]+array[i] ); //golden slice algorithm: Math.max(0, maxRight[i+1]+array[i] )
        }

        // 3) find the maximum of "maxLeft + maxRight"
        int maxDoubleSlice =0;
        for(int i=1; i < array.length-1; i++){ // where "i" means "Y" in this problem
            int maxSum = maxLeft[i-1] + maxRight[i+1];
            if(maxSum > maxDoubleSlice)   // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice = maxSum;  // be careful: "not" maxLeft[i] + maxRight[i]
        }

        return maxDoubleSlice;
    }
}
