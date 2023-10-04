package other.test;

/**
 * Program to find the kth element in linked list
 */
public class FindKthElement {

    private Node head;
    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void addToLast(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printList(Node node) {
        while(node != null) {
            System.out.println(node.value+" ");
            node = node.next;
        }
    }

    public void getKthNode(Node node, int k) {
        if(node == null) {
            System.out.println("List is empty");
        } else {
            Node fast = node;
            Node slow = node;
            int start = 1;

            while(fast.next != null) {
                fast = fast.next;
                start++;

                if(start > k) {
                    slow = slow.next;
                }
            }

            System.out.println("Kth node: "+slow.value);
        }
    }

    public static void main(String[] args) {
        FindKthElement list = new FindKthElement();

        list.addToLast(new Node(1));
        list.addToLast(new Node(7));
        list.addToLast(new Node(3));
        list.addToLast(new Node(2));
        list.addToLast(new Node(9));
        list.addToLast(new Node(6));
        list.addToLast(new Node(11));

        list.printList(list.head);

        list.getKthNode(list.head, 3);
    }
}
