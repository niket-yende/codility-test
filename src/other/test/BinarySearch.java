package other.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Java program to find the index of element using binary search
 * Input: 10 20 30 40 50
 * Output: 2
 */
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Enter array elements: ");
        String[] inputArray = br.readLine().trim().split(" ");

        int[] array = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        System.out.println("Enter search key:");
        int key = Integer.parseInt(br.readLine().trim());

        int output = solution(array, 0, array.length - 1, key);
        System.out.println(output);

        wr.close();
        br.close();
    }

    static int solution(int[] array, int low, int high, int key) {
        int mid = (low + high)/2;

        while(low <= high) {
            if(array[mid] < key){
                low = mid + 1;
            } else if(array[mid] == key) {
                System.out.println("found key: "+key);
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high)/2;
        }

        if(low > high) {
            System.out.println("Key not found");
        }
        return -1;
    }
}
