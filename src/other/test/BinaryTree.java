package other.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Convert a linked list to a binary tree
 * Reference: https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 *
 *    [10]->[12]->[15]->[25]->[30]->[36]
 *    The above linked list represents the below binary tree
 *
 *                       (10)
 *                     /     \
 *                  (12)     (15)
 *                  /  \      /
 *                (25) (30) (36)
 */
public class BinaryTree {
    ListNode head;
    BinaryTreeNode root;

    void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // converts a given linked list representing a
    // complete binary tree into the linked
    // representation of binary tree.
    BinaryTreeNode convertListToBinaryTree(BinaryTreeNode node) {
        // queue to store the parent nodes
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

        // Base Case
        if(head == null) {
            node = null;
            return null;
        }

        // 1.) The first node is always the root node, and add it to the queue
        node = new BinaryTreeNode(head.data);
        queue.add(node);

        // advance the pointer to the next node
        head = head.next;

        while(head != null) {
            // 2.a) take the parent node from the q and peek it from q
            BinaryTreeNode parent = queue.peek();

            // 2.c) take next two nodes from the linked list.
            // We will add them as children of the current
            // parent node in step 2.b. Push them into the
            // queue so that they will be parents to the
            // future nodes
            BinaryTreeNode leftChild, rightChild = null;
            leftChild = new BinaryTreeNode(head.data);
            queue.add(leftChild);
            head = head.next;
            if(head != null) {
                rightChild = new BinaryTreeNode(head.data);
                queue.add(rightChild);
                head = head.next;
            }

            // 2.b) assign the left and right children of parent
            parent.left = leftChild;
            parent.right = rightChild;

            // remove current level node
            queue.poll();
        }
        return node;
    }

    // Utility function to traverse the binary tree after conversion
    public void inorderTraversal(BinaryTreeNode node) {
        if(node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */

        BinaryTreeNode node = tree.convertListToBinaryTree(tree.root);

        System.out.println("Inorder traversal of the constructed binary tree is:");
        tree.inorderTraversal(node);
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right = null;

    BinaryTreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
