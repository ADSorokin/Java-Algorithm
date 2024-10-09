package DZ3.task1;



public class RemoveDuplicates {
    static Node head;

    public static void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(3);
        addNode(4);
        addNode(3);
        addNode(6);

        System.out.println("Before removing duplicates:");
        printList();
        removeDuplicates();
        System.out.println("After removing duplicates:");
        printList();
    }
}






