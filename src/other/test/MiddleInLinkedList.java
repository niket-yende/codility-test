package other.test;

public class MiddleInLinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void print(){
        Node n = head;
        while(n != null){
            System.out.print("-> "+n.data);
            n = n.next;
        }
        System.out.println("");
    }
    /**
     * find middle without using size
     * use fast and slow pointer to find middle element
     *
     */
    public void printMiddle(){
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle->"+slow.data);
    }

    public static void main(String[] args) {
        MiddleInLinkedList llist = new MiddleInLinkedList();
        //Initialize linked list value
        for (int i=5; i>0; --i){
            llist.push(i);
            llist.print();
        }
        llist.printMiddle();
    }
}
