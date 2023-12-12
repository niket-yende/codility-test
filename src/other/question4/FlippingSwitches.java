package other.question4;

/**
 * Program to implement flipping switches problem statement.
 */
public class FlippingSwitches {
    public static void main(String[] args) {
        int[][] operations = {{3, 4}, {2, 3}, {2, 2}};
        int result = finalState(operations);
        System.out.println(result);
    }

    public static int finalState(int[][] operations) {
        boolean[] switches = new boolean[operations.length + 1];

        for (int[] operation : operations) {
            int start = operation[0];
            int end = operation[1];

            for (int i = start; i <= end; i++) {
                int index = i - 1;
                switches[index] = !switches[index];
            }
        }

        int sum = 0;
        for (int i = 0; i < switches.length; i++) {
//            int index = i - 1;
            if (switches[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
