package contest.c2015.hard;

import java.util.Arrays;

/**
 * Given a sequence, find the longest subsequence that can be decomposed into at most three monotonic parts.
 * Reference: https://app.codility.com/programmers/trainings/1/slalom_skiing/
 * https://bojanv55.wordpress.com/2020/01/24/codility-slalomskiing-compact-slow/
 */
public class SlalomSkiing {

    public static void main(String[] args) {
        int[] array1 = {15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3};
        int[] array2 = {1, 5};

        int out1 = solution(array1);
        System.out.println("output1: "+out1);

        int out2 = solution(array2);
        System.out.println("output2: "+out2);
    }

    static int lengthOfLIS(long[] nums) {
        long[] temp = new long[nums.length];
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            int fnd = Arrays.binarySearch(temp, 0, idx, nums[i]);

            if(fnd < 0){
                fnd = -fnd-1;
            }

            if(fnd==idx){
                idx++;
            }

            temp[fnd] = nums[i];
        }
        return idx;
    }

    static int solution(int[] A) {
        long bound = Arrays.stream(A).max().getAsInt();
        long[] withMirrors = new long[A.length*3];
        for(int i=0; i<A.length; i++){
            withMirrors[i*3] = bound * 2 + A[i] + 1;
            withMirrors[i*3+1] = bound * 2 - A[i] + 1;
            withMirrors[i*3+2] = A[i];
        }
        return lengthOfLIS(withMirrors);
    }
}
