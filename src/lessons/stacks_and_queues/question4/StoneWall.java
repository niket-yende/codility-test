package lessons.stacks_and_queues.question4;

import java.util.Stack;

/**
 * Cover "Manhattan skyline" using the minimum number of rectangles.
 * Reference: https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 *            https://github.com/Mickey0521/Codility/blob/master/StoneWall.java
 */
public class StoneWall {
    public static void main(String[] args) {
        int[] array = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] heightArray) {
        Stack<Integer> stack = new Stack<>();
        int numBlock =0;

        // note: heightArray[i] is the ith height of the wall
        for(int i=0; i< heightArray.length; i++){
            // step 1: "stack is not empty" AND "from high to low" then, "pop"
            while(!stack.isEmpty() && stack.peek() > heightArray[i]){
                stack.pop();
            }
            // step 2: Check the stack and push the block element
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < heightArray[i])){
                numBlock++;     // add a block
                stack.push(heightArray[i]);  // push the new block element
            }
        }

        return numBlock;
    }
}
