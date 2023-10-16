package other.coffee_io.level4;

import java.util.Scanner;

/**
 * Program to swap the Kth node of linked list from each of its ends.
 * Input:
 * 4 4
 * 1 2 3 4
 * Output:
 * 4 2 3 1
 */
public class SwapKthNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        int n = sc.nextInt();
        int k = sc.nextInt();
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
        solution(head, n, k);
    }

    static void solution(Node head, int n, int k) {
        int beginPosition = k;
        int endPosition = Math.abs(n - k + 1);

        // Only swap if begin and end positions are different
        if(beginPosition != endPosition) {
            Node x = head;
            Node xPrev = null;
            for (int i = 1; i < beginPosition; i++) {
                xPrev = x;
                x = x.next;
            }

            Node y = head;
            Node yPrev = null;
            for (int i = 1; i < endPosition; i++) {
                yPrev = y;
                y = y.next;
            }

            // If xPrev exists, then new next of it will be y.
            // Consider the case when y->next is x, in this
            // case, xPrev and y are same. So the statement
            // "xPrev->next = y" creates a self loop. This self
            // loop will be broken when we change y->next.
            if (xPrev != null)
                xPrev.next = y;

            // Same thing applies to yPrev
            if (yPrev != null)
                yPrev.next = x;

            // Swap next pointers of x and y.
            Node temp = x.next;
            x.next = y.next;
            y.next = temp;

            // Change head pointers when k is 1 or n
            if (k == 1)
                head = y;

            if (k == n)
                head = x;
        }

        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
}
