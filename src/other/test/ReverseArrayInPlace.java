package other.test;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        solution(array);
    }

    static void solution(int[] array) {
        int first = 0;
        int last = array.length - 1;

        while(first < last) {
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;

            first = first + 1;
            last = last - 1;
        }

        System.out.println("Reversed array: "+Arrays.toString(array));
    }
}
