package data_structures.question3;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

/**
 * Given a tree, find a downward path with the maximal number of direction changes.
 * Reference: https://app.codility.com/programmers/trainings/7/tree_longest_zig_zag/
 * https://github.com/doocs/leetcode/blob/main/solution/1300-1399/1372.Longest%20ZigZag%20Path%20in%20a%20Binary%20Tree/README_EN.md
 */
public class TreeLongestZigZag {
    static int ans;

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.x = 5;
        tree.l = new Tree();
        tree.l.x = 3;
        tree.l.l = new Tree();
        tree.l.l.x = 20;
        tree.l.l.l = new Tree();
        tree.l.l.l.x = 6;
        tree.r = new Tree();
        tree.r.x = 10;
        tree.r.l = new Tree();
        tree.r.l.x = 1;
        tree.r.r = new Tree();
        tree.r.r.x = 15;
        tree.r.r.l = new Tree();
        tree.r.r.l.x = 30;
        tree.r.r.r = new Tree();
        tree.r.r.r.x = 8;
        tree.r.r.l.r = new Tree();
        tree.r.r.l.r.x = 9;

        int out = solution(tree);
        System.out.println(out);
    }

    static int solution(Tree T) {
        dfs(T, 0, 0);
        return ans;
    }

    static void dfs(Tree root, int l, int r) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, Math.max(l, r));
        dfs(root.l, r + 1, 0);
        dfs(root.r, 0, l + 1);
    }
}

