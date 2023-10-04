package other.test;

/**
 * Find the start of loop in a linked list
 */
public class LinkedListStart {
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

    public static void findStartOfLoop(Node node) {
        Node fast = node;
        Node slow = node;
        boolean isLoop = false;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                isLoop = true;
                break;
            }
        }

        if(isLoop) {
            // Reset fast pointer
            fast = node;
            do {
                fast = fast.next;
                slow = slow.next;
            } while(fast != slow);

            System.out.println("Start of loop: "+fast.value);
        } else {
            System.out.println("Linked list does not have a loop");
        }
    }

    public static void main(String[] args) {
        LinkedListStart list = new LinkedListStart();

        Node loopNode = new Node(7);
        list.addToLast(new Node(5));
        list.addToLast(new Node(6));
        list.addToLast(loopNode);
        list.addToLast(new Node(1));
        list.addToLast(new Node(2));

        list.printList(list.head);

        // Creating a loop
        list.addToLast(loopNode);

        findStartOfLoop(list.head);
    }
}
