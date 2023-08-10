package algorithm_skills.question3;

class Tree {
    public int data;
    public Tree left;
    public Tree right;
}

/**
 * Reference: https://app.codility.com/programmers/trainings/4/tree_height/
 */
public class TreeHeight {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.data = 5;
        tree.left = new Tree();
        tree.left.data = 3;
        tree.left.left = new Tree();
        tree.left.left.data = 20;
        tree.left.right = new Tree();
        tree.left.right.data = 21;
        tree.right = new Tree();
        tree.right.data = 10;
        tree.right.left = new Tree();
        tree.right.left.data = 1;

        int height = solution(tree);
        System.out.println(height);
    }

    static int solution(Tree t) {
        if(t == null) {
            return -1;
        } else {
            int leftHeight = solution(t.left);
            int rightHeight = solution(t.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
