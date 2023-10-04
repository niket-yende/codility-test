package other.test;

/**
 * Write a program to check if given linked list has a loop or not
 */
public class LinkedListLoop {
    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public void addToLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public boolean ifLoopExists(Node node) {
        Node slowPtr = node;
        Node fastPtr = node;
        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListLoop list = new LinkedListLoop();

        Node loopNode = new Node(7);
        list.addToLast(new Node(5));
        list.addToLast(new Node(6));
        list.addToLast(loopNode);
        list.addToLast(new Node(1));
        list.addToLast(new Node(2));

        list.printList(list.head);

        // Creating a loop
        list.addToLast(loopNode);

        // Test if loop existed or not
        System.out.println("Loop existed-->" + list.ifLoopExists(list.head));

    }
}
