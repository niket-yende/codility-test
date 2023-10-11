package other.coffee_io.level3;

import java.util.Scanner;

/**
 * Program to exchange first and last nodes of linked list
 *
 * Input:
 * 3
 * 1 2 3
 *
 * Output:
 * 3 2 1
 */
public class ExchangeNodes {
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
        solution(head);
    }

    static void solution(Node head) {
        Node current = head;
        Node beforeLast = null;

        while(current.next != null) {
            beforeLast = current;
            current = current.next;
        }

        current.next = head.next;
        head.next = null;
        beforeLast.next = head;
        head = current;

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
