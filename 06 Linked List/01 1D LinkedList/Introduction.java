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

public class Introduction {
    private static Node converArrayToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    private static int checkIfPresent(Node head, int val) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp = temp.next;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };

        Node head = converArrayToLL(arr);

        // System.out.println(head.data);

        // Node temp = head;

        // while (temp != null) {
        // System.out.println(temp.data + " ");
        // temp = temp.next;
        // }

        // System.out.println(lengthOfLL(head));

        // System.out.println(checkIfPresent(head, 4));
    }
}