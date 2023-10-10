package other.coffee_io.level3;

import other.coffee_io.level2.RearrangeLinkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Program to remove duplicate elements from linked list.
 *
 * Input:
 * 568
 * 67 32 91 36 53 69 45 49 17 97 95 88 89 52 91 80 19 9 31 91 66 96 6 33 34 88 10 72 89 82 77 39 85 48 98 86 19 19 47 68 44 35 42 50 39 18 50 77 4 94 52 58 83 70 66 13 82 18 35 81 41 89 98 54 51 73 56 3 6 43 64 81 32 0 82 62 36 65 62 30 77 38 29 74 58 19 6 1 49 18 13 11 72 6 71 97 73 77 1 78 84 7 82 10 76 50 46 71 34 31 25 35 89 18 94 52 39 73 90 30 64 47 89 66 34 48 42 15 35 77 1 2 65 58 2 29 38 22 12 89 82 59 69 60 18 47 60 86 44 35 35 15 4 84 93 58 65 91 93 32 64 53 20 40 46 87 86 97 99 24 86 85 93 20 81 40 21 5 55 81 3 41 18 92 74 18 29 15 3 19 31 76 64 90 14 64 32 4 31 22 26 14 36 22 2 29 2 42 58 62 69 98 74 79 39 94 94 45 2 4 49 40 6 48 23 90 57 10 25 0 62 71 72 49 51 79 46 67 89 6 76 15 27 98 35 43 81 52 98 5 40 18 74 48 18 78 83 59 49 38 65 99 19 110 29 62 80 7 68 79 79 36 37 64 17 22 57 81 69 49 77 21 25 94 88 0 78 80 28 89 58 97 88 41 58 9 18 97 58 32 98 69 2 78 53 54 43 2 71 35 12 33 90 15 55 86 14 4 35 49 29 12 45 96 86 33 89 48 47 13 26 25 78 53 75 19 12 84 34 34 20 61 78 91 30 62 67 10 97 35 94 45 21 64 93 11 63 97 25 33 37 84 56 87 92 14 51 60 54 64 4 22 10 13 43 49 11 28 40 44 79 24 8 81 73 27 48 14 44 7 49 88 32 34 61 65 58 10 3 43 99 66 71 68 40 66 80 75 25 57 77 47 46 32 20 94 63 79 64 59 40 21 37 19 66 93 15 24 9 84 18 22 68 91 19 54 51 40 6 59 15 42 29 41 35 70 63 33 14 65 83 81 11 8 14 5 41 87 84 45 13 2 10 67 24 53 99 42 90 42 55 25 73 15 44 22 55 51 9 2 69 44 1 44 3 44 3 47 21 45 40 91 49 12 18 61 87 37 1 45 8 11 33 74 59 66 76 43 97 44 63 33 37 49 2 10 88 64 91 46 79 85 12 5 43 82 54 87 84 78 56 18 91 95 20 46 67 82 35 20 41 41 68 66 99 6 35 31 99 66 8 3 1 49 56 51 95 26 18 30 26 38 75 73 74 89 78 3
 *
 * Output:
 * 67 32 91 36 53 69 45 49 17 97 95 88 89 52 80 19 9 31 66 96 6 33 34 10 72 82 77 39 85 48 98 86 47 68 44 35 42 50 18 4 94 58 83 70 13 81 41 54 51 73 56 3 43 64 0 62 65 30 38 29 74 1 11 71 78 84 7 76 46 25 90 15 2 22 12 59 60 93 20 40 87 99 24 21 5 55 92 14 26 79 23 57 27 110 37 28 75 61 63 8
 */
public class RemoveDuplicates {
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

    static void solution(Node node) {
        Set<Integer> set = new HashSet<>();
        Node head = node;

        while(node != null) {
            int currentData = node.data;
            if(node.next != null) {
               int nextData = node.next.data;
               if(set.contains(nextData)) {
                   node.next = findNonRepeatingNode(node.next, node, set);
               }
            }
            set.add(currentData);
            node = node.next;
        }

        printList(head);
    }

    static Node findNonRepeatingNode(Node node, Node currentNode, Set<Integer> set) {
        while(node != null) {
            int nextData = node.data;
            int currentData = currentNode.data;
            if(currentData != nextData && !set.contains(nextData)) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
}
