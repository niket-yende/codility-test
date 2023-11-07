package other.coffee_io.level5;

import java.util.Scanner;

/**
 * Program to implement preorder traversal of a binary tree.
 * Input:
 * 6
 * -24 46 -31 -21 -43 -12
 * Output:
 * -24 -31 -43 46 -21 -12
 */
public class PreorderTraversal {

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
//        root = invertTree(root);

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
}
