package other.coffee_io.level5;

import java.util.Scanner;

/**
 * Program to find the min element in a BST.
 * Input:
 * 6
 * 81 42 87 90 41 66
 * Output:
 * 41
 */
public class FindMinimumElement {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
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
        System.out.println(solution(tree.root));
    }

    public static int solution(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {    // Traverse to the leftmost node
            if (root.left.data < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root.data;
    }
}
