package contest.c2016.question3;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove at most two edges from a tree graph to maximize the product of the components' sizes.
 * Reference: https://app.codility.com/programmers/trainings/2/tree_product/
 */
public class TreeProduct {
    public static void main(String[] args) {
        TreeProduct tp = new TreeProduct();
        int[] A = {0, 1, 1, 3, 3, 6, 7};
        int[] B = {1, 2, 3, 4, 5, 3, 5};
        String out = tp.solution(A, B);
        System.out.println(out);
    }

    class Graph {
        int vertices;
        List<List<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i <= vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        public List<Integer> getNeighbors(int vertex) {
            return adjacencyList.get(vertex);
        }
    }

    public String solution(int[] A, int[] B) {
        int N = A.length;
        Graph graph = new Graph(N + 1);

        for (int i = 0; i < N; i++) {
            graph.addEdge(A[i], B[i]);
        }

        Result result = dfs(graph, 1, -1);
        return String.valueOf(result.maxProduct);
    }

    private Result dfs(Graph graph, int node, int parent) {
        List<Result> results = new ArrayList<>();
        for (int neighbor : graph.getNeighbors(node)) {
            if (neighbor != parent) {
                results.add(dfs(graph, neighbor, node));
            }
        }

        int totalNodes = 1;
        int maxProduct = 0;
        for (Result res : results) {
            totalNodes += res.totalNodes;
            maxProduct = Math.max(maxProduct, res.maxProduct);
        }

        for (Result res : results) {
            int area1 = res.totalNodes;
            int area2 = totalNodes - area1;
            maxProduct = Math.max(maxProduct, area1 * area2);
        }

        return new Result(totalNodes, maxProduct);
    }

    private static class Result {
        int totalNodes;
        int maxProduct;

        Result(int totalNodes, int maxProduct) {
            this.totalNodes = totalNodes;
            this.maxProduct = maxProduct;
        }
    }
}
