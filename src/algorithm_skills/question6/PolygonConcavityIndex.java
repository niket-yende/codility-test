package algorithm_skills.question6;

import java.util.HashSet;
import java.util.Set;

class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * Reference: https://app.codility.com/programmers/trainings/4/polygon_concavity_index/
 */
public class PolygonConcavityIndex {

    public static void main(String[] args) {
        Point2D[] polygon1 = {
                new Point2D(-1, 3),
                new Point2D(1, 2),
                new Point2D(3, 1),
                new Point2D(0, -1),
                new Point2D(-2, 1)
        };

        int out1 = solution(polygon1);
        System.out.println("out1: "+ out1);

        Point2D[] polygon2 = {
                new Point2D(-1, 3),
                new Point2D(1, 2),
                new Point2D(1, 1),
                new Point2D(3, 1),
                new Point2D(0, -1),
                new Point2D(-2, 1),
                new Point2D(-1, 2)
        };

        int out2 = solution(polygon2);
        System.out.println("out2: "+ out2);
    }

    static int solution(Point2D[] A) {
        int N = A.length;
        if (N < 3) {
            return -1; // Not enough points to form a polygon
        }

        // Find the leftmost point as the starting point
        int startPoint = 0;
        for (int i = 1; i < N; i++) {
            if (A[i].x < A[startPoint].x || (A[i].x == A[startPoint].x && A[i].y < A[startPoint].y)) {
                startPoint = i;
            }
        }

        int currentPoint = startPoint;
        Set<Integer> convexHull = new HashSet<>();

        while (true) {
            int nextPoint = (currentPoint + 1) % N;
            for (int i = 0; i < N; i++) {
                if (i != currentPoint && i != nextPoint) {
                    int crossProduct = crossProduct(A[currentPoint], A[nextPoint], A[i]);
                    if (crossProduct > 0) {
                        nextPoint = i;
                    }
                }
            }

            convexHull.add(currentPoint);
            currentPoint = nextPoint;

            if (currentPoint == startPoint) {
                break;
            }
        }

        // Check if any point not in the convex hull
        for (int i = 0; i < N; i++) {
            if (!convexHull.contains(i)) {
                return i;
            }
        }

        return -1; // Convex polygon
    }

    static int crossProduct(Point2D p1, Point2D p2, Point2D p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }
}
