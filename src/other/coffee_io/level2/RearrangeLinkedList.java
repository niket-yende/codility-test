package other.coffee_io.level2;

import other.test.LinkedListLoop;
import other.test.LinkedListStart;

import java.util.Scanner;

public class RearrangeLinkedList {
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

    public static void solution(Node node) {
        // split the linked list into an odd and an even list
        Node oddHead = null;
        Node oddTail = null;
        Node evenHead = null;
        Node evenTail = null;
        int currentIndex = 0;
        Node currentNode = node;

        while(currentNode != null) {
            currentIndex++;
            if(currentIndex % 2 == 0) {
                // push node to even list
                if(evenHead == null) {
                    evenHead = currentNode;
                    evenTail = evenHead;
                } else {
                    evenTail.next = currentNode;
                    evenTail = currentNode;
                }
            } else {
                // push node to odd list
                if(oddHead == null) {
                    oddHead = currentNode;
                    oddTail = oddHead;
                } else {
                    oddTail.next = currentNode;
                    oddTail = currentNode;
                }
            }
            currentNode = currentNode.next;
        }

        if(oddHead == null || evenHead == null) {
            return;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        printList(oddHead);

        return;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
}
