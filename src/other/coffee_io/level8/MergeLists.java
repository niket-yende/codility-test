package other.coffee_io.level8;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Program to merge lists using priority queue.
 * Input1:
 * 3
 * 3
 * 1 4 5
 * 3
 * 1 3 4
 * 2
 * 2 6
 * Output1:
 * 1 1 2 3 4 4 5 6
 * Input2:
 * 1
 * 0
 * []
 * Output2:
 * []
 */
public class MergeLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Node[] arr = new Node[K];
        for (int j = 0; j < K; j++) {
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
            arr[j] = head;
        }
        solution(K, arr);
    }

    static void solution(int k, Node[] arr) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (Node list : arr) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        Node dummy = new Node(0);
        Node current = dummy;

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        printList(dummy.next);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
