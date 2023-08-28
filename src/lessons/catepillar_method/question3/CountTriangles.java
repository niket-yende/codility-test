package lessons.catepillar_method.question3;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        int array[] = {10, 2, 5, 1, 8, 12};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        int triangleCount = 0;

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int leftEnd = i + 1;
            int rightEnd = i + 2;

            while(leftEnd < array.length - 1) {
                if(rightEnd < array.length && (array[i] + array[leftEnd] > array[rightEnd])) {
                    rightEnd++;
                } else {
                    triangleCount = triangleCount + (rightEnd - leftEnd - 1);
                    leftEnd++;
                }
            }
        }

        return triangleCount;
    }
}
