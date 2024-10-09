package DZ3.task2;


    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public class MyLinkedList {
        public static int findMiddle(ListNode head) {
            if (head == null) {
                throw new IllegalArgumentException("List should not be empty");
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.value;
        }

        public static void main(String[] args) {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4);
            node4.next = node5;
            ListNode node3 = new ListNode(3);
            node3.next = node4;
            ListNode node2 = new ListNode(2);
            node2.next = node3;
            ListNode node1 = new ListNode(1);
            node1.next = node2;

            int middleValue = findMiddle(node1);
            System.out.println(middleValue);
        }
    }

