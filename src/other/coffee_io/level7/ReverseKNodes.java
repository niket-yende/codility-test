package other.coffee_io.level7;

import java.util.Scanner;

/**
 * Program to reverse k nodes.
 * Input:
 * 34
 * 26 766 145 414 463 169 226 279 966 5 847 385 968 693 617 887 262 606 708 98 135 523 39 675 900 21 497 879 379 290 48 22 125 25
 * 6
 * Output:
 * 169 463 414 145 766 26 385 847 5 966 279 226 606 262 887 617 693 968 675 39 523 135 98 708 290 379 879 497 21 900 48 22 125 25
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

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        Node currGroupStart = head;

        for (int i = 0; i < count / k; i++) {
            Node groupEnd = currGroupStart;
            Node nextGroupStart = currGroupStart.next;

            for (int j = 1; j < k; j++) {
                Node temp = nextGroupStart.next;
                nextGroupStart.next = groupEnd;
                groupEnd = nextGroupStart;
                nextGroupStart = temp;
            }

            prevGroupEnd.next = groupEnd;
            currGroupStart.next = nextGroupStart;

            prevGroupEnd = currGroupStart;
            currGroupStart = nextGroupStart;
        }

        return dummy.next;
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
        printList(reverseKGroup(head, k));
    }
}
