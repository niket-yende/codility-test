package other.coffee_io.level5;

import java.util.Scanner;

/**
 * Program to reorder binary tree using preorder traversal.
 * Input:
 * 6
 * 26 20 4 -8 31 24
 * Output:
 * 26 31 20 24 4 -8
 */
public class ReorderBinaryTree {
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
        solution(tree.root);
    }

    static void solution(Node root) {
        // Invert the binary tree
        root = invertTree(root);

        // Perform preorder traversal and print the updated tree
        preorderTraversal(root);
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // Swap left and right subtrees
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
