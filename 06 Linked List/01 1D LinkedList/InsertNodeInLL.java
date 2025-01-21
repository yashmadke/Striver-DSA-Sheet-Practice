import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node next;

    // constructors
    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class InsertNodeInLL {
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");

            head = head.next;
        }
    }

    public static Node insertHead(Node head, int val) {
        Node temp = new Node(val, head);

        return temp;
    }

    public static Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // head = insertHead(head, val);

        head = insertEnd(head, val);

        print(head);
    }
}