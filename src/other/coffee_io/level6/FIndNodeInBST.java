package other.coffee_io.level6;

import java.util.Scanner;

/**
 * Find the node in the BST.
 * Input:
 * 7
 * 2 81 42 87 90 45 66
 * Output:
 * 87
 */
public class FIndNodeInBST {
    public static boolean flag = false;
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
        System.out.println(solution(tree.root, K));
    }

    static int solution(Node root, int k) {
        searchNode(root, k);
        System.out.println("flag "+flag);
        return flag ? 1 : 0;
    }

    static void searchNode(Node temp, int value){
        //If value is found in the given binary tree then, set the flag to true
        if(temp.data == value){
            flag = true;
            return;
        }
        //Search in left subtree
        if(flag == false && temp.left != null){
            searchNode(temp.left, value);
        }
        //Search in right subtree
        if(flag == false && temp.right != null){
            searchNode(temp.right, value);
        }
    }
}
