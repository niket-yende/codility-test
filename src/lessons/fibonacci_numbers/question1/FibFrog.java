package lessons.fibonacci_numbers.question1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Count the minimum number of jumps required for a frog to get to the other side of a river.
 * Reference: https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/
 *            https://github.com/Mickey0521/Codility/blob/master/FibFrog.java
 */
public class FibFrog {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};

        int out = solution(array);
        System.out.println(out);
    }

    static int solution(int[] array) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        while(true){
            int temp1 = fibonacci.get( fibonacci.size()-1 );
            int temp2 = fibonacci.get( fibonacci.size()-2 );
            fibonacci.add(temp1 + temp2);

            // if already bigger than length, then break;
            if(temp1 + temp2 > array.length){
                break;
            }
        }

        // reverse "List": from big to small
        Collections.reverse(fibonacci);

        // use "queue" with "point"
        // point(x,y) = point("position", "number of steps")
        ArrayList<Point> queue = new ArrayList<>();
        queue.add( new Point(-1, 0) ); // position:-1, steps:0

        // index: the current index for queue element
        int index=0;
        while(true){
            // cannot take element from queue anymore
            if(index == queue.size() ){
                return -1;
            }

            // take element from queue
            Point current = queue.get(index);

            // from big to small
            for(Integer n: fibonacci){
                int nextPosition = current.x + n;

                // case 1: "reach the other side"
                if(nextPosition == array.length){
                    // return the number of steps
                    return current.y + 1;
                }

                // case 2: "cannot jump"
                // note: nextPosition < 0 (overflow, be careful)
//                else if( (nextPosition > array.length) || (nextPosition < 0)|| (array[nextPosition]==0) ){
//                    // note: do nothing
//                }

                // case 3: "can jump" (othe cases)
                else if((nextPosition < array.length) && (nextPosition > 0) && (array[nextPosition] == 1)){
                    // jump to next position, and step+1
                    Point temp = new Point(nextPosition, current.y + 1);
                    // add to queue
                    queue.add(temp);

                    array[nextPosition] = 0; // key point: for high performance~!!
                }
            }

            index++;
        }
    }
}
