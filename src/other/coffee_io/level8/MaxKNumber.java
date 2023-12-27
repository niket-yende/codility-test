package other.coffee_io.level8;
import java.util.Scanner;

/**
 * Program to print an array of k digits representing max number.
 * Input1:
 * 4 6
 * 3 4 6 5
 * 9 1 2 5 8 3
 * 5
 * Output1:
 * 9 8 6 5 3
 *
 * Input2:
 * 2 2
 * 3 9
 * 8 9
 * 3
 * Output2:
 * 9 8 9
 */
public class MaxKNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        solution(arr1, arr2, n, m, k);
    }

    public static void solution(int[] arr1, int[] arr2, int n, int m, int k) {
        int[] result = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxArray(arr1, i), maxArray(arr2, k - i), k);
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        System.out.println("Output:");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }

    private static int[] maxArray(int[] nums, int k) {
        int[] result = new int[k];
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            while (length > 0 && length + nums.length - i > k && nums[i] > result[length - 1]) {
                length--;
            }
            if (length < k) {
                result[length++] = nums[i];
            }
        }

        return result;
    }

    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {
            result[r++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }

        return result;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}

