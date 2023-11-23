package other.coffee_io.level8;

import java.util.Scanner;

/**
 * Program to delete key node.
 * Input:
 * 7
 * 2 81 42 87 90 41 66
 * 42
 * Output:
 * 2 81 66 41 87 90
 */
public class DeleteKeyNode {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    static class BST {
        Node root;

        public void insert(int val) {
            Node newNode = new Node(val);
            if(root == null) {
                root = newNode;
            } else {
                Node temp = root;
                while(true) {
                    if(temp.data == newNode.data) {
                        break;
                    }
                    if(newNode.data < temp.data) {
                        if(temp.left == null) {
                            temp.left = newNode;
                            break;
                        } else {
                            temp = temp.left;
                        }
                    } else {
                        if(temp.right == null) {
                            temp.right = newNode;
                            break;
                        } else {
                            temp = temp.right;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BST tree = new BST();
        for (int i = 0; i < N; i++) {
            tree.insert(sc.nextInt());
        }
        int K = sc.nextInt();
        solution(tree.root, K);
    }

    static void solution(Node root, int K) {
        root = deleteRec(root, K);
        preorderTraversal(root);
    }

    static Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    static int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
