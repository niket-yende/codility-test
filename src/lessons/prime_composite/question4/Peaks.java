package lessons.prime_composite.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].
 * Reference: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
 *            https://github.com/Mickey0521/Codility/blob/master/Peaks.java
 */
public class Peaks {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        List<Integer> peaksIndexList = new ArrayList<>();

        // 1) find the peaks (and store them)
        for(int i=1; i<array.length-1; i++){
            if( array[i-1]<array[i] && array[i]>array[i+1] ){
                peaksIndexList.add(i);
            }
        }

        // 2) check the number of Blocks
        int n = array.length;

        // from the "biggest possible number" to smaller number
        for(int numBlocks = n; numBlocks >= 1; numBlocks--){

            if( n % numBlocks == 0){ // it is divisible

                int blockSize = n / numBlocks;
                int ithOkBlock = 0;  // the ith block has peak(s)

                // test all the peaks
                // if a peak is found in the ith block
                // then, go to the (i+1)th block
                for(int peaksIndex : peaksIndexList){
                    if( peaksIndex / blockSize == ithOkBlock){ // peak in the ith block
                        ithOkBlock++; // go to check (i+1)th block
                    }
                }

                // ithOkBlock: the number of blocks having peak(s)
                // if all the blocks have peak(s)
                // then, return the number of blocks
                // note: we test from the biggest possible number
                // so, once we find it, we can just return it
                // (no need to check the smaller possible numbers)
                if(ithOkBlock == numBlocks){
                    return numBlocks;
                }
            }
        }

        return 0;
    }
}
