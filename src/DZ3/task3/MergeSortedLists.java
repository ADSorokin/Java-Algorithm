package DZ3.task3;


    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public class MergeSortedLists {

        public static ListNode mergeLists(ListNode l1, ListNode l2) {
            // Создаем временной узел, который облегчит сборку нового списка
            ListNode temp = new ListNode(0);
            ListNode cur = temp; // Указатель на текущий конец нового списка

            // Пока оба списка не пусты
            while (l1 != null && l2 != null) {
                // Выбираем элемент с меньшим значением и добавляем его в новый список
                if (l1.value < l2.value) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next; // Переходим к следующему месту в новом списке
            }

            // Если один список закончился, присоединяем остаток другого списка
            if (l1 != null) {
                cur.next = l1;
            } else {
                cur.next = l2;
            }

            // Возвращаем начало нового списка (после временного узла)
            return temp.next;
        }

        public static void main(String[] args) {
            // Создаем первый отсортированный список: 1 -> 3 -> 5
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(3);
            l1.next.next = new ListNode(5);

            // Создаем второй отсортированный список: 2 -> 4 -> 6
            ListNode l2 = new ListNode(2);
            l2.next = new ListNode(4);
            l2.next.next = new ListNode(6);
            l2.next.next.next = new ListNode(9);
            l2.next.next.next.next = new ListNode(-7);


            // Слияние списков
            ListNode mergedList = mergeLists(l1, l2);

            // Выводим элементы нового списка
            ListNode current = mergedList;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            // Вывод: 1 2 3 4 5 6
        }
    }


