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

public class DeleteNodeInLL {
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");

            head = head.next;
        }
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    private static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };

        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);

        // head = deleteTail(head);

        // deleteNode(head.next.next);

        print(head);
    }
}