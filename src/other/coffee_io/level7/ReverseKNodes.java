package other.coffee_io.level7;

import java.util.Scanner;

/**
 * Program to reverse k nodes.
 * Reference: https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 */
public class ReverseKNodes {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    static Node reverseKNodes(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;

        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* 2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }

        /* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = reverseKNodes(current.next, k);
        }

        /* 5) prev is new head of the input list */
        return prev;
    }

    // prints content of double linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node newNode = new Node(x);
            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        int k = sc.nextInt();
        solution(head, k);
    }

    static void solution(Node head, int k) {
        head = reverseKNodes(head, k);

        printList(head);
    }
}
